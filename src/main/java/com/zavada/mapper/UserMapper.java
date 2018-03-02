package com.zavada.mapper;

import org.springframework.security.core.authority.AuthorityUtils;

import com.zavada.domain.EditUserRequest;
import com.zavada.domain.RegisterRequest;
import com.zavada.entity.User;

public interface UserMapper {

	// Ohhhh.. need to change User entity class name
	public static org.springframework.security.core.userdetails.User toUser(User user) {
		return 
				new org.springframework.security.core.userdetails.User(
						user.getEmail(), user.getPassword(), AuthorityUtils.createAuthorityList(String.valueOf(user.getRole())));
	}
	
	public static User registerToUser(RegisterRequest request) {
		User user = new User();
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		user.setRole(request.getRole());
		return user;
	}
	
	public static User editToUser(EditUserRequest request) {
		User user = new User();
		user.setId(request.getId());
		user.setFullName(request.getFullName());
		user.setAge(request.getAge());
		user.setCountry(request.getCountry());
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		user.setUserImage(request.getProfileImage().getOriginalFilename());
		user.setRole(request.getRole());
		user.setEdited(true);
		return user;
	}
	
	public static EditUserRequest userToEdit(User user) {
		EditUserRequest request = new EditUserRequest();
		request.setId(user.getId());
		request.setEmail(user.getEmail());
		request.setFullName(user.getFullName());
		request.setAge(user.getAge());
		request.setCountry(user.getCountry());
		request.setPassword(user.getPassword());
		request.setRole(user.getRole());
		return request;
	}
}
