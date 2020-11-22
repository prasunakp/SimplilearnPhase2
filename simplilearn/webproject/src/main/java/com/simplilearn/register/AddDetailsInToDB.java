package com.simplilearn.register;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddDetailsInToDB {

	public static void main(String[] args)
	{
	// Get a reference to the SessionFactory
	SessionFactory theFactory = new Configuration()
								.configure("hibernate.cfg.xml").addAnnotatedClass(FlightModel.class)
								.addAnnotatedClass(PlaceModel.class)
								.buildSessionFactory();
	try {
	Session theSession = theFactory.getCurrentSession();
	
	FlightModel flightDetails = new FlightModel("Indigo", "Mumbai", "Delhi" ,100,"INR");
	
	PlaceModel place = new PlaceModel("Mumbai", "Delhi");
	
	theSession.beginTransaction();
	
//	Save the New StudentDetails object
	theSession.save(flightDetails);
	theSession.save(place);
	
//	Commit the transaction
	theSession.getTransaction().commit();
	}
	finally {
		theFactory.close();
	}
	
	}
	
}
