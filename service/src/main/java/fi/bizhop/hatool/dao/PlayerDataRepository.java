package fi.bizhop.hatool.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fi.bizhop.hatool.entity.PlayerData;

public interface PlayerDataRepository extends CrudRepository<PlayerData, Integer> {
	List<PlayerData> findAll();
}
