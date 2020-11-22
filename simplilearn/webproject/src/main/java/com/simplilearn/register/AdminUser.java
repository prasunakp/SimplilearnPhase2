package com.simplilearn.register;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //Tells Hibernate this is our Entity class
@Table(name = "adminUser")
public class AdminUser {
	
    @Id
	@Column(name = "name")
	String name;

	@Column(name = "password")
	String password;
	
	public AdminUser()
	{
		
	}

	public AdminUser(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
