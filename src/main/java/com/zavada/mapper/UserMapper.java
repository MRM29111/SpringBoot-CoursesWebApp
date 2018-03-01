package com.zavada.mapper;

import com.zavada.domain.RegisterRequest;
import com.zavada.entity.User;

public interface UserMapper {

	public static User toUser(RegisterRequest request) {
		User user = new User();
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		
		return user;
	}
	
}
