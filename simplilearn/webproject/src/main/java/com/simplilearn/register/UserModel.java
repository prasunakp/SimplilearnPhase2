package com.simplilearn.register;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //Tells Hibernate this is our Entity class
@Table(name = "userModel")
public class UserModel {
	
    @Id
	@Column(name = "email")
	String email;

	@Column(name = "phone")
	Integer phone;
	
	@Column(name = "name")
	String name;

	@Column(name = "flightNumber")
	String flightNumber;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	
	public UserModel()
	{
		
	}
	
	public UserModel(String email, Integer phone, String name, String flightNumber) {
		this.email = email;
		this.phone = phone;
		this.name = name;
		this.flightNumber = flightNumber;
	}


}
