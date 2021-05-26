package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;


public class UpdateStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
			int studentId=1;
			
			
			
			//	now get a session and start transaction
			session=factory.getCurrentSession();
			session.beginTransaction();
			
			//retrived student based on primary key
			System.out.println("geting student with id"+studentId);
			Student mystudent=session.get(Student.class, studentId);
			
			System.out.println("Get Complete "+mystudent);
			
			System.out.println("updating student");
			mystudent.setFirstName("MahendraSingh");
			//commit transaction
		session.getTransaction().commit();
			
			//		now get a session and start transaction
				session=factory.getCurrentSession();
				session.beginTransaction();
				
				session.createQuery("update Student set email='foo@gmail.com' ").executeUpdate();
				
				//commit transaction
				session.getTransaction().commit();
		
		System.out.println("Done");
		}
		finally {
			factory.close();
		}
		

	}

}
