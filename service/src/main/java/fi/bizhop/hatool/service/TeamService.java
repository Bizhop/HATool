package fi.bizhop.hatool.service;

import java.lang.reflect.Method;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fi.bizhop.hatool.dao.PlayerDataRepository;
import fi.bizhop.hatool.dao.PlayerRepository;
import fi.bizhop.hatool.dto.Line;
import fi.bizhop.hatool.dto.LinePlayer;
import fi.bizhop.hatool.dto.LinesDto;
import fi.bizhop.hatool.entity.Player;
import fi.bizhop.hatool.entity.PlayerData;
import fi.bizhop.hatool.entity.Position;
import fi.bizhop.hatool.entity.Status;

@Service
public class TeamService {

	@Autowired
	PlayerRepository playerRepo;

	@Autowired
	PlayerDataRepository playerDataRepo;

	public LinesDto getBestLines() {
		LinesDto lines = new LinesDto();

		List<Player> players = playerRepo.findByActiveTrue();
		
		//Poistetaan myytävät pelaajat
		Player sell = findByStatus(players, Status.SELL);
		while(sell != null) {
			lines.getSell().add(new LinePlayer(sell.getId(), sell.getName(), sell.getPosition().toString()));
			players.remove(sell);
			sell = findByStatus(players, Status.SELL);
		}

		//Maalivahdit
		Player mv = findByPosition(players, Position.G);
		while(mv != null) {
			lines.getGoalies().add(new LinePlayer(mv.getId(), mv.getName(), mv.getPosition().toString()));
			players.remove(mv);
			mv = findByPosition(players, Position.G);
		}

		//Tehokkaimmat pelaajat kolmeen ensimmäiseen ketjuun
		processLines(players, lines);

		//Parhaat juniorit nelosketjuun ja siitä seuraavat junnuketjuihin
		processYouthLines(players, lines);

		//loput pelaajat ekstroihin
		for(Player p : players) {
			lines.getExtra().add(new LinePlayer(p.getId(), p.getName(), p.getPosition().toString()));
		}

		return lines;
	}

	private void processLines(List<Player> players, LinesDto lines) {
		players.sort((p1, p2) -> p2.getLatestData().getEfficiency() - p1.getLatestData().getEfficiency());

		processLine(players, lines, "Y1");
		processLine(players, lines, "Y2");
		processLine(players, lines, "Y3");
	}

	private void processYouthLines(List<Player> players, LinesDto lines) {
		players.sort((p1, p2) -> p2.getLatestData().getGrowthPotential() - p1.getLatestData().getGrowthPotential());

		processLine(players, lines, "Y4");
		processLine(players, lines, "J1");
		processLine(players, lines, "J2");
		processLine(players, lines, "J3");
	}

	private void processLine(List<Player> players, LinesDto lines, String lineName) {
		try {
			Method getter = LinesDto.class.getMethod("get" + lineName);
			Line line = (Line)getter.invoke(lines);

			Player ld = findByPosition(players, Position.D);
			if(ld != null) {
				line.setLd(new LinePlayer(ld.getId(), ld.getName(), ld.getPosition().toString()));
				players.remove(ld);
			}

			Player rd = findByPosition(players, Position.D);
			if(rd != null) {
				line.setRd(new LinePlayer(rd.getId(), rd.getName(), rd.getPosition().toString()));
				players.remove(rd);
			}

			Player c = findByPosition(players, Position.C);
			if(c != null) {
				line.setC(new LinePlayer(c.getId(), c.getName(), c.getPosition().toString()));
				players.remove(c);
			}

			Player rw = findByPosition(players, Position.W);
			if(rw != null) {
				line.setRw(new LinePlayer(rw.getId(), rw.getName(), rw.getPosition().toString()));
				players.remove(rw);
			}

			Player lw = findByPosition(players, Position.W);
			if(lw != null) {
				line.setLw(new LinePlayer(lw.getId(), lw.getName(), lw.getPosition().toString()));
				players.remove(lw);
			}
		} catch (Exception e) {}
	}

	private Player findByPosition(List<Player> players, Position pos) {
		for(Player p : players) {
			if(p.getPosition() == pos) {
				System.out.println(String.format("Found player %s by position %s", p.getName(), p.getPosition() ));
				return p;
			}
		}
		return null;
	}
	
	private Player findByStatus(List<Player> players, Status status) {
		for(Player p : players) {
			if(p.getStatus() == status) {
				System.out.println(String.format("Found player %s by status %s", p.getName(), p.getStatus() ));
				return p;
			}
		}
		return null;
	}

	public boolean updateValues() {
		try {
			for(PlayerData data : playerDataRepo.findAll()) {
				boolean altered = false;
				if(data.getQuality() != null && data.getPotential() != null) {
					data.setGrowthPotential(data.getQuality() * data.getPotential());
					altered = true;
				}
				if(data.getAbilityIndex() != null && data.getExperience() != null) {
					data.setEfficiency(data.getAbilityIndex() + (data.getExperience() / 2));
					altered = true;
				}
				if(altered) {
					playerDataRepo.save(data);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		return true;
	}
}
