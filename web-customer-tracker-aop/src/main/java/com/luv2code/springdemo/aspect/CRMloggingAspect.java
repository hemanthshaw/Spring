package com.luv2code.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMloggingAspect {
//set up logger
private Logger myLogger=Logger.getLogger(getClass().getName());
	
//set up pointcut declerations
@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))") 
private void forControllerPackage()
{}

@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))") 
private void forServicePackage()
{}

@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))") 
private void forDAOPackage(){}

@Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
private void forAppFlow() {}

//add @Before advice
@Before("forAppFlow()")
public void before(JoinPoint thejoinPoint)
{
//display methods
	String theMethod=thejoinPoint.getSignature().toShortString();
	myLogger.info("=====> in @Before calling method:  "+theMethod);
	
	//display args
	Object[] args=thejoinPoint.getArgs();
	
	for(Object tempArg: args)
	{
		myLogger.info("====>>argument "+tempArg);
	}
	
}

	
//add @After returning advice
	
@AfterReturning(
		pointcut="forAppFlow()",
		returning="theResult"
		)
public void afterReturning(JoinPoint theJoinPoint, Object theResult)
{
	String theMethod=theJoinPoint.getSignature().toShortString();
	myLogger.info("=====> in @After returning method:  "+theMethod);  
	myLogger.info("=====> result : "+theResult);
	
}


}
