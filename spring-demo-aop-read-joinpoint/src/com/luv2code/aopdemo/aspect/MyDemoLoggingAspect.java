package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

		
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDAOPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint)
	{
		System.out.println("\n ====> Executing @Before advice on add Account()");
		//to read method signature
		MethodSignature methodSig= (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("Method : "+methodSig);
		
		//display method signature
		
		//get ars
		
		Object[] args=theJoinPoint.getArgs();
		
		//loop thru args
		for(Object tempArg:args)
		{
			System.out.println(tempArg);
			
			if(tempArg instanceof Account)
			{
				//downcast and account specific stuff
					 Account theAccount=(Account) tempArg;
					 System.out.println("acccount name : "+ theAccount.getName());

					 System.out.println("acccount level : "+ theAccount.getLevel());
			}
			
		}
			
		
	}
	
	
	
}
