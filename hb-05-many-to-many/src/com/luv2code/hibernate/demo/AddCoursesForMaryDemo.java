package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;


public class AddCoursesForMaryDemo {

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
			
			//create a course
			int studentId=2;
			Student tempStudent=session.get(Student.class, studentId);
			System.out.println("Loading courses for student "+tempStudent+ "is");
			System.out.println(tempStudent.getCourses());
			
			//create more courses
			Course tempCourses1=new Course("How to solve Rubix cube");
			Course tempCourses2=new Course("Atari 2006 Game development");
			
			//add students to course
			tempCourses1.addStudents(tempStudent);
			tempCourses2.addStudents(tempStudent);
			
			//save courses
			session.save(tempCourses1);
			session.save(tempCourses2);
			
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
