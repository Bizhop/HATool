package fi.bizhop.hatool.dao;

import org.springframework.data.repository.CrudRepository;

import fi.bizhop.hatool.entity.Player;

public interface PlayerRepository extends CrudRepository<Player, Integer> {

	Player findByName(String nimi);

}
