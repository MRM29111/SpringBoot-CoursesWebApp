package com.zavada.mapper;

import com.zavada.domain.EditUserRequest;
import com.zavada.domain.RegisterRequest;
import com.zavada.entity.User;

public interface UserMapper {

	public static User toUser(RegisterRequest request) {
		User user = new User();
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		
		return user;
	}
	
	public static User editToUser(EditUserRequest request) {
		User user = new User();
		user.setId(request.getId());
		user.setFullName(request.getFullName());
		user.setAge(request.getAge());
		user.setUserImage(request.getUserImagePath());
		user.setCountry(request.getCountry());
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
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
		return request;
	}
}
