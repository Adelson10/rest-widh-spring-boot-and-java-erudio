package com.adelsonbarros.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adelsonbarros.exceptions.ResourceNotFoundException;
import com.adelsonbarros.model.Person;
import com.adelsonbarros.repositories.PersonRepository;

@Service
public class PersonService {
	
	private static final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonService.class.getName());
	
	@Autowired
	PersonRepository repository;
	
	public List<Person> findAll() {
		logger.info("Finding All person!");
		List<Person> persons = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		return repository.findAll();
	}
	
	public Person findById(Long id) {
		
		logger.info("Finding one person...");
		
		Person person = new Person();
		person.setId(counter.getAndIncrement());
		person.setFirstName("Adelson");
		person.setLastName("Barros");
		person.setAddress("Colinas do Tocantins - Tocantins - Brasil");
		person.setGender("male");
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
	}
	
	public Person create(Person person) {
		logger.info("Creating one person!");
		return repository.save(person);
	}
	
	public Person update(Person person) {
		
		logger.info("Updating one person!");
		
		var entity = repository.findById(person.getId())
			.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		return repository.save(person);
	}
	
	public void delete(Long id) {
		logger.info("Delete one person!");
		
		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		repository.delete(entity);
	}
	
	private Person mockPerson(int i) {
		
		logger.info("Finding one person!");
		
		Person person = new Person();
		person.setId(counter.getAndIncrement());
		person.setFirstName("Adelson " + i);
		person.setLastName("Barros" + i);
		person.setAddress("Colinas do Tocantins - Tocantins - Brasil" + i);
		person.setGender("male");
		return person;
	}
	
}
