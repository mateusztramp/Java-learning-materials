package com.tramp.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainSpring {
	public static void main(String[]args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		
		User user = context.getBean("user",User.class);
		Address addresss = context.getBean("addresss",Address.class);
		
		System.out.println("user");
		
	
	
	

	}
}
