package com.springdemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdemo.entities.Person;

@Service
public class PersonService {
	
	private List<Person> personList;	
	
	@Autowired
	public PersonService() {
		personList = new ArrayList<>();
		personList.add(new Person("2000X", "Carl", "Johnson", 1800666));
	}
	
	public List<Person> getAllPersons(){
		return personList;
	}
	
	public boolean addPerson(Person person) {
		
		return true;
	}
}
