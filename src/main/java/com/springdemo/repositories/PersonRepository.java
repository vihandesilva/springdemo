package com.springdemo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springdemo.entities.Person;
@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {
	
	public Person findByNic(String nic);
	
	public Person findByName(String firstName, String lastName);

}
