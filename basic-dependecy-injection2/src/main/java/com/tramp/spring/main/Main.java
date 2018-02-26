package com.tramp.spring.main;

import com.tramp.spring.Logger;
import com.tramp.spring.UsersRepository;
import com.tramp.spring.domain.User;
import com.tramp.spring.implementations.LoggerImpl;
import com.tramp.spring.implementations.UsersRepositoryImpl;

public class Main {

	public static void main(String[] args) {
	Logger logger = new LoggerImpl();
	UsersRepository usersRepository = new UsersRepositoryImpl();
	usersRepository.setLogger(logger);
	
	User user = usersRepository.createUser("Janek");
	

	}

}
