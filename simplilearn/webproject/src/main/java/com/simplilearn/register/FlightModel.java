package com.simplilearn.register;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //Tells Hibernate this is our Entity class
@Table(name = "flightModel")
public class FlightModel {
	
    @Id
	@Column(name = "flightNumber")
    @GeneratedValue(strategy=GenerationType.IDENTITY)

	Integer flightNumber;

	@Column(name = "flightName")
	String flightName;
	
	@Column(name = "source")
	String source;

	@Column(name = "destination")
	String destination;

	@Column(name = "price")
	int price;

	@Column(name = "currency")
	String currency;
	
	public FlightModel()
	{
		
	}
	
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	
	public Integer getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(Integer flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
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

	public FlightModel( String flightName, String source, String destination, int price, String currency) {
		this.flightName = flightName;
		this.source = source;
		this.destination = destination;
		this.price = price;
		this.currency = currency;
	}
	
	@Override
	public String toString() {
		return "FlightModel [stdId=" + flightNumber + ", flightName=" + flightName + ", source =" + source +", destination ="+destination + "]";
	}
}
