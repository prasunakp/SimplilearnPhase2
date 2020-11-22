package com.simplilearn.register;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //Tells Hibernate this is our Entity class
@Table(name = "orderModel")
public class OrderModel {


		@Id
		@Column(name = "orderNumber")
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
		Integer orderNumber ;

		@Column(name = "user")
		String user;
		
		@Column(name = "flightNumber")
		String flightNumber;

		@Column(name = "price")
		String  price;
		
		
	    public Integer getOrderNumber() {
		return orderNumber;
	}
	    
		public OrderModel()
		{
			
		}
	    
	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public OrderModel(String user, String flightNumber, String price) {
		this.user = user;
		this.flightNumber = flightNumber;
		this.price = price;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
