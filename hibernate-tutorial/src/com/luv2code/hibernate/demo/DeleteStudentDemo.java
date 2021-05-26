package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;


public class DeleteStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
			int studentId=4;
			
			
			
			//	now get a session and start transaction
			session=factory.getCurrentSession();
			session.beginTransaction();
			
			//retrived student based on primary key
			System.out.println("geting student with id"+studentId);
			Student mystudent=session.get(Student.class, studentId);
			
			//delete the student
			System.out.println("Delete the student"+mystudent);
				session.delete(mystudent);
			
			//delete student id=2
			System.out.println("delete student id=2");
			session.createQuery("delete from Student where id=2").executeUpdate();
			
			//commit transaction
			session.getTransaction().commit();
			
			
		
		System.out.println("Done");
		}
		finally {
			factory.close();
		}
		

	}

}
