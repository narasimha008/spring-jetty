package com.user.web.service;

import java.util.List;

import com.user.web.model.Person;

public interface PersonService {

	public List<Person> getAllPersons();
	
	public void insertPerson(Person person);
	
	Person getPerson(Integer id);
	
	void deletePerson(Integer id);
	
	void updatePerson(Person employee);
}
