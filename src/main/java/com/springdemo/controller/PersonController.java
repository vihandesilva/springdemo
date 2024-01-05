package com.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springdemo.entities.Person;
import com.springdemo.repositories.PersonRepository;
import com.springdemo.service.PersonService;

@RequestMapping("/person")
@RestController
public class PersonController {
	@Autowired
	private PersonService personService;
	
	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	@GetMapping("/all")
	public List<Person> getPersonList(){
		List<Person> persons = personService.getAllPersons();
		return persons;
	}
}
