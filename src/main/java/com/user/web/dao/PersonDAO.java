package com.user.web.dao;

import java.util.List;

import com.user.web.model.Person;

public interface PersonDAO {

	public List<Person> getAllPersons();
	
	public void insertPerson (Person person);
	
	Person getPerson(Integer id);
	
	void deletPerson(Person employee);
	
	void updatePerson(Person employee);
}
