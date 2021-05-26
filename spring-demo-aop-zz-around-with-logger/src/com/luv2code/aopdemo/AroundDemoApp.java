package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);			
		System.out.println("\n Main Program : Around Demo App");
		System.out.println("Calling get fortune");
		String data=theFortuneService.getFortune();
		System.out.println("My fortune is "+data);
		System.out.println("Finished ");	
		// call method to find the accounts
		
	
	}

}










