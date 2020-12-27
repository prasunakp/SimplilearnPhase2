package com.simplilearn.register;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class GetFlightDetailsFromDB {

	public List<FlightModel> getFlights(String source, String destination) {
		// TODO Auto-generated method stub
		
		SessionFactory theFactory = new Configuration()
				.configure("hibernate.cfg.xml").addAnnotatedClass(FlightModel.class)
				.addAnnotatedClass(PlaceModel.class)
				.buildSessionFactory();
		
		Session theSession = theFactory.getCurrentSession();
		
		theSession.beginTransaction();

		List<FlightModel> flightDetails = theSession.createQuery("from FlightModel u where u.source = '"+source+"' and u.destination = '"+destination+"'").getResultList();

       // List<FlightModel> flightDetails = query.getResultList();
		for(FlightModel flight : flightDetails) {
			System.out.println(flight.getDestination());
		}
       return flightDetails;
	}
	
	public FlightModel getFlightById(int id)
	{
		SessionFactory theFactory = new Configuration()
				.configure("hibernate.cfg.xml").addAnnotatedClass(FlightModel.class)
				.addAnnotatedClass(PlaceModel.class)
				.buildSessionFactory();	
		
		Session theSession = theFactory.getCurrentSession();
		
		theSession.beginTransaction();
		
		FlightModel flight = theSession.get(FlightModel.class, id);
		
		return flight;
	}
	
	public List<PlaceModel> getallPlaces()
	{
		SessionFactory theFactory = new Configuration()
				.configure("hibernate.cfg.xml").addAnnotatedClass(FlightModel.class)
				.addAnnotatedClass(PlaceModel.class)
				.buildSessionFactory();	
		
		Session theSession = theFactory.getCurrentSession();
		
		theSession.beginTransaction();
		
		List<PlaceModel> places = theSession.createQuery("from PlaceModel").getResultList();
		
		return places;
	}
	
	public List<FlightModel> getallFlights()
	{
		SessionFactory theFactory = new Configuration()
				.configure("hibernate.cfg.xml").addAnnotatedClass(FlightModel.class)
				.addAnnotatedClass(PlaceModel.class)
				.buildSessionFactory();	
		
		Session theSession = theFactory.getCurrentSession();
		
		theSession.beginTransaction();
		
		List<FlightModel> flights = theSession.createQuery("from FlightModel").getResultList();
		
		return flights;
	}

}
