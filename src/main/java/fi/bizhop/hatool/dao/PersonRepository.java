package fi.bizhop.hatool.dao;

import org.springframework.data.repository.CrudRepository;

import fi.bizhop.hatool.entity.Person;

public interface PersonRepository extends CrudRepository<Person, Integer> {
	Person findByEmail(String email);
}
