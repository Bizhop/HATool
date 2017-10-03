package fi.bizhop.hatool.dao;

import org.springframework.data.repository.CrudRepository;

import fi.bizhop.hatool.entity.Player;
import fi.bizhop.hatool.entity.PlayerData;

public interface PlayerDataRepository extends CrudRepository<PlayerData, Integer> {
	PlayerData findFirstByPlayerByOrderByCreatedAtDesc(Player player);
}
