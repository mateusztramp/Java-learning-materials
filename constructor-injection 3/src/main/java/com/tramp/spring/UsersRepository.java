package com.tramp.spring;

import com.tramp.spring.domain.User;

public interface UsersRepository {
	User createUser(String name);

	
}
