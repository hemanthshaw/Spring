package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	//we add all our related advices for logging
	
	//let's start with an @Before advice
	
	/*
	@Before("execution(public void addAccount())")
	public void beforeAddAccountAdvice()
	{
		System.out.println("\n ====> Executing @Before advice on add Account()");
	}
	*/
	
	/*
	@Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
	public void beforeAddAccountAdvice()
	{
		System.out.println("\n ====> Executing @Before advice on add Account()");
	}
	*/
	
	/*@Before("execution(* add*())")
	public void beforeAddAccountAdvice()
	{
		System.out.println("\n ====> Executing @Before advice on add Account()");
	}
	*/
	/*@Before("execution(* add*(com.luv2code.aopdemo.Account,..))")
	public void beforeAddAccountAdvice()
	{
		System.out.println("\n ====> Executing @Before advice on add Account()");
	}
	*/
	/*@Before("execution(* add*(..))")
	public void beforeAddAccountAdvice()
	{
		System.out.println("\n ====> Executing @Before advice on add Account()");
	}*/
	
	//To match any method in a given package	
	/*@Before("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void beforeAddAccountAdvice()
	{
		System.out.println("\n ====> Executing @Before advice on add Account()");
	}
	 */
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	private void forDAOPackage()
	{}
	
	@Before("forDAOPackage()")
	public void beforeAddAccountAdvice()
	{
		System.out.println("\n ====> Executing @Before advice on add Account()");
	}
	
	@Before("forDAOPackage()")
	public void performApiAnalytics()
	{
		System.out.println("\n ====> Executing @Perform Api Analytics()");
	}
	
}
