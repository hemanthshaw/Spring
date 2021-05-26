package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;


public class GetCourseAndReviewsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		//create a session
		Session session=factory.getCurrentSession();
		
		try {
				
			
			
			//start a transaction
			session.beginTransaction();
			
			//get the course
			int theid=10;
			Course tempCourse=session.get(Course.class, theid);
			
			//print the course
			System.out.println(tempCourse);
			
			
			//print the course reviews
			System.out.println(tempCourse.getReviews());
			
			//Commit Transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}
		finally {
			//add clean up code
			session.close();
			factory.close();
		}
		

	}

}