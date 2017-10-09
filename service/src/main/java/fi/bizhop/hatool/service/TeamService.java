package fi.bizhop.hatool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fi.bizhop.hatool.dao.PlayerDataRepository;
import fi.bizhop.hatool.dao.PlayerRepository;
import fi.bizhop.hatool.dto.LinesDto;
import fi.bizhop.hatool.entity.Player;
import fi.bizhop.hatool.entity.PlayerData;

@Service
public class TeamService {
	
	@Autowired
	PlayerRepository playerRepo;
	
	@Autowired
	PlayerDataRepository playerDataRepo;

	public LinesDto getBestLines() {
		List<Player> players = playerRepo.findByActiveTrue();
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
