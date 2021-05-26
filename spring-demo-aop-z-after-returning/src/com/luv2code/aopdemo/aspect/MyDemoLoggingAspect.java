package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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

	
	
	@AfterReturning(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",returning="result"
			)
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint,List<Account> result)
	{
		String method=theJoinPoint.getSignature().toShortString();
		
		System.out.println("\n===> Executing @After returning on method "+method);
		
	
		//process the data and modify it
		
		//convert names to upppercase
		convertAccountNamesToUpperCase(result);
		System.out.println("\n===> Result is "+result);
	}
	
	
	
	
		
	private void convertAccountNamesToUpperCase(List<Account> result) {
		// TODO Auto-generated method stub
		
		for(Account tempAccount: result)
		{
			String theUpperName=tempAccount.getName().toUpperCase();	
			tempAccount.setName(theUpperName);
		}
		
	}





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
