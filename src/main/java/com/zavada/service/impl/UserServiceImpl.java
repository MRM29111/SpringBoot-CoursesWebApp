package com.zavada.service.impl;

import org.springframework.stereotype.Service;

import com.zavada.entity.User;
import com.zavada.repository.UserRepository;
import com.zavada.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User findUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}

	@Override
	public void saveUser(User user) {
		userRepository.save(user);
	}

	@Override
	public User findUserByEmailAndPassword(String email, String password) {
		return userRepository.findUserByEmailAndPassword(email, password);
	}

	@Override
	public User findUserById(int id) {
		return userRepository.findOne(id);
	}
	
	

}
