package com.zavada.service;

import com.zavada.entity.User;

public interface UserService {

	User findUserByEmail(String email);
	
	void saveUser(User user);

	User findUserById(int id);
	
	void editUser(User user);
	// User findUserByEmailAndPassword(String email, String password);
}
