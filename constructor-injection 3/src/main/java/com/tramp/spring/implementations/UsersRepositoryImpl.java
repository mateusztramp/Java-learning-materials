package com.tramp.spring.implementations;

import com.tramp.spring.Logger;
import com.tramp.spring.UsersRepository;
import com.tramp.spring.domain.User;

public class UsersRepositoryImpl implements UsersRepository {
	private Logger logger;
	

	public UsersRepositoryImpl(Logger logger,String localization) {
		this.logger = logger;
		logger.log("Lokalizacja repozytorium: " + localization);
	}


	public User createUser(String name) {
	logger.log("tworzenie u¿ytkownika "+ name);
		return new User(name);
	}


}
