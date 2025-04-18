package com.Spring.orm.HibernatePractice.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HIbernateUtil {
          private static SessionFactory sessionFactory;
          
          static {
        	  try {
        		  sessionFactory= new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        	  }catch(Exception e) {
        		throw new RuntimeException("Error in creating sessionFactory:"+e.getMessage());
        	  }
        	  
        	  
          }
          
          public static SessionFactory getSessionFactory() {
        	  return sessionFactory;
          }
}
