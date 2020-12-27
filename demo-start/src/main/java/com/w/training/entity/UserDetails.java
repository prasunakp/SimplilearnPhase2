package com.w.training.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //Tells Hibernate this is our Entity class
@Table(name = "userDetails")
public class UserDetails {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	int id;
	
	@Column(name = "emailid")
	String emailid;
	
	@Column(name = "name")
	String name;
	
	@Column(name = "phonenumber")
	String phonenumber;
	
public UserDetails(String emailid, String name, String phonenumber) {
		this.emailid = emailid;
		this.name = name;
		this.phonenumber = phonenumber;
	}


public UserDetails() {
		
	}

public String getEmailid() {
	return emailid;
}


public void setEmailid(String emailid) {
	this.emailid = emailid;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getPhonenumber() {
	return phonenumber;
}


public void setPhonenumber(String phonenumber) {
	this.phonenumber = phonenumber;
}


	@Override
	public String toString() {
		return "StudentDetails [id=" + id + ", name=" + name + ", "
				+ "emailId=" + emailid + ", phoneNumber=" + phonenumber + "]";
	}

}
