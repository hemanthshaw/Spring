package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;


public class QueryStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			//query students
			
			List<Student> thestudents=session.createQuery("from Student").getResultList();
			
			//display students
			displayStudents(thestudents);
			
			//display all the student whose last name "Dravid"
			
			List<Student> thestudents1=session.createQuery("from Student s where s.lastName='Dravid'").getResultList();
			System.out.println("\n\ndisplay all the student whose last name Dravid");
			displayStudents(thestudents1);
			
			//query students first name="MS" or last name="Tendulkar"
			
			thestudents=session.createQuery("from Student s where"
						+" s.firstName='MS' OR s.lastName='Tendulkar'").getResultList();
			System.out.println("\n\nquery students first name='MS' or last name='Tendulkar'");
			displayStudents(thestudents);
			
			//query where email id is '%luv2code.com'
			
			thestudents=session.createQuery("from Student s where s.email like '%luv2code.com'").getResultList();
			System.out.println("\n\nquery where email id is '%luv2code.com'");
			displayStudents(thestudents);
			
			
			
			
			
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}
		finally {
			factory.close();
		}
		

	}

	private static void displayStudents(List<Student> thestudents) {
		for(Student tempstudent: thestudents)
		{
			System.out.println(tempstudent);
		}
	}

}
