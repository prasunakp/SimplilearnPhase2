package com.simplilearn.register;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //Tells Hibernate this is our Entity class
@Table(name = "placeModel")
public class PlaceModel {

	@Id
	@Column(name = "source")
	String source;
	
	@Column(name = "destination")
	String destination;
	
	public PlaceModel()
	{
		
	}
		
	
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public PlaceModel(String source, String destination) {
		this.source = source;
		this.destination = destination;
	}

}
