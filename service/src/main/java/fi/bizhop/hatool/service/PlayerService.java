package fi.bizhop.hatool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fi.bizhop.hatool.dao.PlayerDataRepository;
import fi.bizhop.hatool.dao.PlayerRepository;
import fi.bizhop.hatool.dto.PlayerDto;
import fi.bizhop.hatool.entity.Player;
import fi.bizhop.hatool.entity.PlayerData;

@Service
public class PlayerService {

	@Autowired
	PlayerRepository playerRepo;
	
	@Autowired
	PlayerDataRepository dataRepo;

	public boolean savePlayers(List<PlayerDto> players) {
		try {
			for(PlayerDto dto : players) {
				Player player = playerRepo.findByName(dto.getNimi());
				if(player == null) {
					player = new Player();
					player.setName(dto.getNimi());
					player = playerRepo.save(player);
				}
				PlayerData data = new PlayerData();
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
				if(player.getData() == null || player.getData().isEmpty()) {
					
				}
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
