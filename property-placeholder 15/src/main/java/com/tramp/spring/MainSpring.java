package com.tramp.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainSpring {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

		SomeBean someBean = context.getBean("someBean", SomeBean.class);
		System.out.println(someBean.getProperty());
		
		DatabaseRepository db = context.getBean("myDatabase",DatabaseRepository.class);
		
		System.out.println(db);

	}
}
