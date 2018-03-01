package com.zavada.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import com.zavada.domain.RegisterRequest;

@Component
public class CheckPasswordsMatchValidator implements ConstraintValidator<CheckPasswordsMatch, RegisterRequest> {

	@Override
	public void initialize(CheckPasswordsMatch constraintAnnotation) {

	}

	@Override
	public boolean isValid(RegisterRequest user, ConstraintValidatorContext context) {
		
		if(user.getPassword() == null || user.getPasswordConfirm() == null) {
			return false;
		}
		
		if(user.getPassword().equals(user.getPasswordConfirm())) {
			return true;
		}
		return false;
	}

}
