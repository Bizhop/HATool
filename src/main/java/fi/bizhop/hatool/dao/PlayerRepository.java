package fi.bizhop.hatool.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import fi.bizhop.hatool.entity.Person;
import fi.bizhop.hatool.entity.Player;
import fi.bizhop.hatool.projection.PlayerDetailsProjection;
import fi.bizhop.hatool.projection.PlayerListingProjection;

public interface PlayerRepository extends PagingAndSortingRepository<Player, Integer> {
	
	List<Player> findAll();

	Player findByName(String nimi);
	
	Page<PlayerListingProjection> findByActiveTrueAndOwner(Person owner, Pageable pageable);
	
	List<Player> findByActiveTrueAndOwner(Person owner);
	
	PlayerDetailsProjection findByIdAndOwner(Integer id, Person owner);

	@Modifying
	@Query("UPDATE Player SET active = false WHERE owner = :owner")
	void disableAllByOwner(@Param("owner") Person owner);
}
