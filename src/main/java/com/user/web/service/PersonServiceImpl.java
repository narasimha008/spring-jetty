package com.user.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.web.dao.PersonDAO;
import com.user.web.model.Person;


@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDAO personDao;
	
	public List<Person> getAllPersons() {
		List<Person> persons = personDao.getAllPersons();
		return persons;
	}

	public void insertPerson(Person person) {
		personDao.insertPerson(person);
	}

	public Person getPerson(Integer id){
		return personDao.getPerson(id);
	}
	
	public void deletePerson(Integer id){
		personDao.deletPerson(personDao.getPerson(id));
	}
	
	public void updatePerson(Person employee){
		personDao.updatePerson(employee);
	}
}
