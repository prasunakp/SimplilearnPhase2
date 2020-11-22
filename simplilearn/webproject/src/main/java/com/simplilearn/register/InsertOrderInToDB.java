package com.simplilearn.register;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InsertOrderInToDB {
	
	public OrderModel insertOrder(String user,String flightNumber,String price)
	{
		SessionFactory theFactory = new Configuration()
				.configure("hibernate.cfg.xml").addAnnotatedClass(OrderModel.class)
				.buildSessionFactory();
		Session theSession = theFactory.getCurrentSession();
		
		theSession.beginTransaction();
		
		OrderModel order = new OrderModel(user, flightNumber, price);
		
		theSession.save(order);
		theSession.getTransaction().commit();
		return order;
	}

}
