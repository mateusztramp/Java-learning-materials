package com.tramp.spring.implementations;

import com.tramp.spring.Logger;
import com.tramp.spring.UsersRepository;
import com.tramp.spring.domain.User;

public class UsersRepositoryImpl implements UsersRepository {
	private Logger logger;

	public User createUser(String name) {
	logger.log("tworzenie u¿ytkownika "+ name);
		return new User(name);
	}

	public void setLogger(Logger logger) {
		this.logger=logger;
	}

}
