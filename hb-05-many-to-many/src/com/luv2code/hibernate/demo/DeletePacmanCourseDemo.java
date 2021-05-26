package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;


public class DeletePacmanCourseDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		//create a session
		Session session=factory.getCurrentSession();
		
		try {
				
			
			
			//start a transaction
			session.beginTransaction();
			
			//get pacman coursee from db
			int theCourseId=10;
			
			Course theCourse=session.get(Course.class,theCourseId);
			
			//delete the course
			System.out.println("Deleting the Course "+ theCourse);
			session.delete(theCourse);
			
			
			
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
