package com.tramp.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainSpring {
	public static void main(String[]args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		SomeClass someClass = context.getBean("someClass",SomeClass.class);
		SomeClass someClass2 = context.getBean("someClass2",SomeClass.class);
		
		System.out.println(someClass2.getUser().getName());
		
		
	

	}
}
