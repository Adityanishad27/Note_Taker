package com.helper;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Factoryprovider {
	
	public static SessionFactory factory;
	
	
	
	public static SessionFactory getFactory() {
		
		if(factory==null) {
			
			factory= new Configuration().configure("hibernateConfig.xml").buildSessionFactory();
			
		}
		
	
		return factory;
	}
	
	
	public void closeFactory() {
		
		if(factory.isOpen()) {
			
			factory.close();
			
		}
		
	}

}
