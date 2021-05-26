package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public void addAccount()
	
	{
		System.out.println(getClass()+"Adding a member ship account");
	}
public void addSillyMember()
	
	{
		System.out.println(getClass()+"This is a silly method");
	}

public void goToSleep()
{
	System.out.println(getClass()+"Go to sleep");
}


}