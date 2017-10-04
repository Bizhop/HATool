package fi.bizhop.hatool.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fi.bizhop.hatool.dao.PlayerRepository;
import fi.bizhop.hatool.dto.PlayerDto;
import fi.bizhop.hatool.entity.Player;
import fi.bizhop.hatool.entity.PlayerData;

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
					player.getData().add(data);
					player.setActive(true);
					playerRepo.save(player);
				}
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

	public List<Player> getActivePlayers() {
		return playerRepo.findByActiveTrue();
	}
}
