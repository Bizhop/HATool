package fi.bizhop.hatool.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fi.bizhop.hatool.entity.Player;

public interface PlayerRepository extends CrudRepository<Player, Integer> {

	Player findByName(String nimi);
	
	List<Player> findByActiveTrue();

	@Modifying
	@Query("UPDATE Player SET active = false")
	void disableAll();
}
