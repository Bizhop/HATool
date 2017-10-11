package fi.bizhop.hatool.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fi.bizhop.hatool.dao.PlayerRepository;
import fi.bizhop.hatool.dto.PlayerDto;
import fi.bizhop.hatool.dto.UpdatePlayerDto;
import fi.bizhop.hatool.entity.Player;
import fi.bizhop.hatool.entity.PlayerData;
import fi.bizhop.hatool.entity.Position;
import fi.bizhop.hatool.entity.Status;
import fi.bizhop.hatool.projection.PlayerDetailsProjection;
import fi.bizhop.hatool.projection.PlayerListingProjection;

@Service
public class PlayerService {

	@Autowired
	PlayerRepository playerRepo;

	@Transactional
	public boolean savePlayers(List<PlayerDto> players) {
		playerRepo.disableAll();
		try {
			for(PlayerDto dto : players) {
				Player player = playerRepo.findByName(dto.getNimi());
				if(player == null) {
					player = new Player();
					player.setName(dto.getNimi());
				}
				if(player.getData() == null) {
					player.setData(new ArrayList<PlayerData>());
				}
				Date latest = findLatest(player.getData());
				if(latest == null || !DateUtils.isSameDay(latest, new Date())) {
					PlayerData data = new PlayerData();
					data.setPlayer(player);
					data.setAge(dto.getIka());
					data.setQuality(dto.getLah());
					data.setPotential(dto.getPot());
					data.setGoalie(dto.getMv());
					data.setDefence(dto.getPuol());
					data.setAttack(dto.getHyokk());
					data.setShooting(dto.getLauk());
					data.setPassing(dto.getSyo());
					data.setSpeed(dto.getNop());
					data.setStrength(dto.getVoim());
					data.setSelfControl(dto.getIhi());
					data.setForm(dto.getKnto());
					data.setExperience(dto.getKok());
					data.setAbilityIndex(dto.getTi());
					data.setWeeks(dto.getViikko());
					if(dto.getLah() != null && dto.getPot() != null) {
						data.setGrowthPotential(dto.getLah() * dto.getPot());
					}
					if(dto.getTi() != null && dto.getKok() != null) {
						data.setEfficiency(dto.getTi() + (dto.getKok() / 2));
					}
					player.getData().add(data);
					player.setLatestData(data);
					player.setPosition(Position.G); //default value
					player.setStatus(Status.NEW); //default value
				}
				player.setActive(true);
				playerRepo.save(player);
			}
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	private Date findLatest(List<PlayerData> list) {
		Date latest = null;
		for(PlayerData data : list) {
			if(latest == null || latest.before(data.getCreatedAt())) {
				latest = data.getCreatedAt();
			}
		}
		return latest;
	}

	public Page<PlayerListingProjection> getActivePlayers(Pageable pageable) {
		return playerRepo.findByActiveTrue(pageable);
	}

	public PlayerDetailsProjection getPlayer(Integer id) {
		return playerRepo.findById(id);
	}

	public PlayerDetailsProjection updatePlayer(Integer id, UpdatePlayerDto dto) {
		Player player = playerRepo.findOne(id);
		player.setPosition(dto.getPosition());
		player.setStatus(dto.getStatus());
		playerRepo.save(player);
		return playerRepo.findById(id);
	}
}
