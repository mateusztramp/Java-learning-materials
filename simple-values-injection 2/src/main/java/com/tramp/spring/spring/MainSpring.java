package com.tramp.spring.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tramp.spring.UsersRepository;
import com.tramp.spring.domain.User;

public class MainSpring {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		
		UsersRepository usersRepository = context.getBean("usersrepository", UsersRepository.class);

			User janek = usersRepository.createUser("Janek");
	}

}
