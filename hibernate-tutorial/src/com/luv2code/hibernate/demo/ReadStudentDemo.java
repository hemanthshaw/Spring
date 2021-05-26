package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;


public class ReadStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
			System.out.println("Creating new student Object");
			Student tempStudent=new Student("Virat","Kohli","vk@luv2code.com");
			
			session.beginTransaction();
			
			System.out.println("Saving the student");
			System.out.println(tempStudent);
			
			session.save(tempStudent);
			
			session.getTransaction().commit();
			
			//Findout the student id's primary key
			System.out.println("Saved student.Generated id :"+tempStudent.getId());
			
			
			//	now get a session and start transaction
			session=factory.getCurrentSession();
			session.beginTransaction();
			
			//retrived student based on primary key
			System.out.println("geting student with id"+tempStudent.getId());
			Student mystudent=session.get(Student.class, tempStudent.getId());
			
			System.out.println("Get Complete "+mystudent);
			//commit transaction
		session.getTransaction().commit();
		
		System.out.println("Done");
		}
		finally {
			factory.close();
		}
		

	}

}
