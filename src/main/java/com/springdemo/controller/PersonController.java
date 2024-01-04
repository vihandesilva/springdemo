package com.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springdemo.entities.Person;
import com.springdemo.repositories.PersonRepository;

@RestController
public class PersonController {
	
	@Autowired
	PersonRepository personRepository;

	@GetMapping("/{nic}")
	public ResponseEntity<Person> getPersonById(@PathVariable("nic") String id){
		Person person = personRepository.findByNic(id);
		return new ResponseEntity<Person>(person, HttpStatus.OK);
	}
}
