package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;


public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		//create a session
		Session session=factory.getCurrentSession();
		
		try {
				
				//start a transaction
			session.beginTransaction();
			
			//get instructor detail object
			int theId=299;
			InstructorDetail tempInstructorDetail=session.get(InstructorDetail.class, theId);
					
			//print the instructor detail
					System.out.println("tempInstructorDetail "+tempInstructorDetail);
			
			//print the associated Instructor
			System.out.println("print the associated Instructor"+tempInstructorDetail.getInstructor());
			
			//Commit Transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}
		catch(Exception exc) {
			exc.printStackTrace();
			
		}
		
		finally {
			//handle the connnection leak
			session.close();
			factory.close();
		}
		

	}

}
