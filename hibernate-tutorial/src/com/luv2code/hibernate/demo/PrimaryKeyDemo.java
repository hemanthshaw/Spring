package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		//Create Session Factory
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		//Create Session
		Session session=factory.getCurrentSession();
		
		try {
			
			//create a 3 student Objects
			System.out.println("Creating 3 student Objects");
			
			Student tempStudent1=new Student("MS","Dhoni","msd@luv2code.com");
			Student tempStudent2=new Student("Sachin","Tendulkar","st@luv2code.com");
			Student tempStudent3=new Student("Rahul","Dravid","rd@luv2code.com");
			
			//Start a transaction
			session.beginTransaction();
			
			//Save the student object
			System.out.println("Saving the student");
			
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}
		finally {
			factory.close();
		}
		
		

	}

}
