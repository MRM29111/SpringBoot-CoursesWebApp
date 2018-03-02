package com.zavada.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.zavada.entity.User;
import com.zavada.repository.UserRepository;
import com.zavada.service.UserService;

@Service
@Qualifier("userServiceImpl")
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public User findUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}

	@Override
	@Transactional
	public void saveUser(User user) {
		String password = user.getPassword();
		user.setPassword(passwordEncoder.encode(password));
		userRepository.save(user);
	}

	@Override
	public User findUserById(int id) {
		return userRepository.findOne(id);
	}

	@Override
	public void editUser(User user) {
		userRepository.save(user);
	}
	

	/*@Override
	public User findUserByEmailAndPassword(String email, String password) {
		return userRepository.findUserByEmailAndPassword(email, password);
	}*/
	
}
