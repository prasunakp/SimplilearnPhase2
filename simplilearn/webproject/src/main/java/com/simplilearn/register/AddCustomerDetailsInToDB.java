package com.simplilearn.register;

import java.util.Collection;
import java.util.List;

import javax.print.attribute.standard.RequestingUserName;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class AddCustomerDetailsInToDB {
	
	public UserModel addcustomer(String email,int phone, String name, String flightNumber)
	{
		SessionFactory theFactory = new Configuration()
				.configure("hibernate.cfg.xml").addAnnotatedClass(UserModel.class).buildSessionFactory();
		
		Session theSession =	theFactory.getCurrentSession();
		
		theSession.beginTransaction();
		
		UserModel user = new UserModel();
		
		user = new UserModel(email, phone, name, flightNumber);
		
		theSession.save(user);
		
		theSession.getTransaction().commit();
		
		return user;

	}
	
	public AdminUser addadmin(String userName, String password)
	{
		SessionFactory theFactory = new Configuration()
				.configure("hibernate.cfg.xml").addAnnotatedClass(AdminUser.class).buildSessionFactory();
Session theSession =	theFactory.getCurrentSession();
		
		theSession.beginTransaction();
		
		AdminUser user = new AdminUser(userName, password);
		
		theSession.save(user);
		
		theSession.getTransaction().commit();
		
		return user;
	}
	
	public AdminUser getAdmin(String userName)
	{
		SessionFactory theFactory = new Configuration()
				.configure("hibernate.cfg.xml").addAnnotatedClass(AdminUser.class).buildSessionFactory();
        Session theSession =	theFactory.getCurrentSession();
        theSession.beginTransaction();
		AdminUser user = theSession.get(AdminUser.class, userName);
      if(user!=null)
      {
    	  return user;
      }
		return null;

	}
	
	public AdminUser updatePassword (String userName , String password)
	{
		SessionFactory theFactory = new Configuration()
				.configure("hibernate.cfg.xml").addAnnotatedClass(AdminUser.class).buildSessionFactory();
        Session theSession =	theFactory.getCurrentSession();
        theSession.beginTransaction();
		AdminUser user = theSession.get(AdminUser.class, userName);
		user.setPassword(password);
theSession.save(user);
		
		theSession.getTransaction().commit();
		return user;
		
	}

}
