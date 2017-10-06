package fi.bizhop.hatool.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import fi.bizhop.hatool.entity.Player;
import fi.bizhop.hatool.projection.PlayerProjection;

public interface PlayerRepository extends PagingAndSortingRepository<Player, Integer> {

	Player findByName(String nimi);
	
	Page<PlayerProjection> findByActiveTrue(Pageable pageable);

	@Modifying
	@Query("UPDATE Player SET active = false")
	void disableAll();
}
