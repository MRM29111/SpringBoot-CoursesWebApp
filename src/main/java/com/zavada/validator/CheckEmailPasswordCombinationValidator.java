package com.zavada.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zavada.domain.LoginRequest;
import com.zavada.service.UserService;

@Component
public class CheckEmailPasswordCombinationValidator implements ConstraintValidator<CheckEmailPasswordCombination, LoginRequest>{

	@Autowired private UserService userService;
	
	@Override
	public void initialize(CheckEmailPasswordCombination constraintAnnotation) {
		
	}

	@Override
	public boolean isValid(LoginRequest request, ConstraintValidatorContext context) {
		
		return userService.findUserByEmailAndPassword(request.getEmail(), request.getPassword()) == null ? false : true;
	}

	
	
}
