package com.user.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PERSON_INFO")
public class Person {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "U_AGE")
	private Integer uage;
		
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	public Integer getUage() {
		return uage;
	}
	public void setUage(Integer uage) {
		this.uage = uage;
	}
	@Override
	public boolean equals(Object obj){
		if (this == obj){
			return true;
		}
		Person person = (Person) obj;
		if (firstName != null ?
				!firstName.equals(person.firstName)
				:person.firstName != null){
			return false;
		}
		else {
			return true;
		}	
	}
	@Override
	public String toString() {
		return "Person [id=" 
				+ id 
				+ ", name=" 
				+ firstName 
				+ " " 
				+ lastName 
				+ "]";
	}
}
