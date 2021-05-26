package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;


public class FetchJoinDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		//create a session
		Session session=factory.getCurrentSession();
		
		try {
				
			
			
			//start a transaction
			session.beginTransaction();
			
			//option 2:Hibernate Query with HQL.
			
			//get the instructor from db
			int theId=1;
			
			Query<Instructor> query=session.createQuery("Select i from Instructor i "
					+ "JOIN FETCH i.courses "
					+ " where i.id=:theInstructorId",	
					Instructor.class);
			
			//set paramaeter on query
			query.setParameter("theInstructorId",theId);
			
			//execute query and get instructor
			Instructor tempInstructor =query.getSingleResult();
			
			System.out.println("LUV2CODE : Instructor : "+tempInstructor);
			
						
			//Commit Transaction
			session.getTransaction().commit();
			
			session.close();
			
			System.out.println("Session is now closed");
			
			//since courses are lazy it should fail
			
			System.out.println("LUV2CODE : Instructor courses are"+tempInstructor.getCourses());

			
			
			System.out.println("LUV2CODE : Done");
			
		}
		finally {
			//add clean up code
			session.close();
			factory.close();
		}
		

	}

}
