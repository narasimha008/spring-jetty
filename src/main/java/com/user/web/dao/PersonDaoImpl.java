package com.user.web.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.user.web.model.Person;

@Repository
@Transactional(readOnly = true)
public class PersonDaoImpl implements PersonDAO {

	@Autowired
	private SessionFactory sessionFactory;


	@SuppressWarnings("unchecked")
	public List<Person> getAllPersons() {
		Session session = sessionFactory.openSession();
		String hql = "FROM Person";
		Query query = session.createQuery(hql);
		List<Person> persons = query.list();
		return persons;
	}

	public Person getPerson(Integer id) {
		Session session = sessionFactory.openSession();
		Person person = (Person) session.get(Person.class,id);
		return person;
	}

	@Transactional(readOnly = false)
	public void insertPerson(Person employee) {
		Session session = sessionFactory.openSession();
		session.save(employee);
	}
	
	@Transactional(readOnly = false)
	public void updatePerson(Person employee) {
		Session session = sessionFactory.openSession();
		String hql = "update Person set firstName='"+employee.getFirstName()+"',lastName='"+employee.getLastName()+"',uage="+employee.getUage()+" where id="+employee.getId();
		Query query = session.createQuery(hql);
		query.executeUpdate();
	}
	
	@Transactional(readOnly = false)
	public void deletPerson(Person employee) {
		Session session = sessionFactory.openSession();
		String hql = "delete from Person where id="+employee.getId();
		Query query = session.createQuery(hql);
		query.executeUpdate();
	}

}
