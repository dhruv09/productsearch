package com.hib.main;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hib.UserDetails;


public class Product {

	
	
	public static SessionFactory getConn()
	{
		SessionFactory sf = new Configuration().configure().addAnnotatedClass(UserDetails.class).buildSessionFactory();
		return sf;
	}
	
	
	} 
	
