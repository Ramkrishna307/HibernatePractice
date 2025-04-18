package com.Spring.orm.HibernatePractice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.Spring.orm.HibernatePractice.Entities.Student;
import com.Spring.orm.HibernatePractice.util.HIbernateUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        Student student=new Student();
        student.setName("Ram");
        student.setPhone("23456890");
        student.setCollege("ABC");
        student.setFathername("XYZ");
        student.setActive(false);
        student.setAbout("Okay 1st Entry Done");
        
        
       SessionFactory sessionFactory= HIbernateUtil.getSessionFactory();
       System.out.println(sessionFactory);
       
       
       Session session=sessionFactory.openSession();
       Transaction transaction=null;
       
       try {
    	     transaction =session.beginTransaction();
    	     session.persist(student);
    	     transaction.commit();
    	     System.out.println("Student saved successfully");
       }catch(Exception e) {
    	   
    	   if(transaction != null) {
    		    transaction.rollback();
    	   }
    	   e.printStackTrace();
       }finally {
    	   session.close();
       }
    }
}
