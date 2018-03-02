package com.zavada.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckEmailPasswordCombinationValidator.class)
public @interface CheckEmailPasswordCombination {

	String message() default "Entered combination of email and passowrd are not correct. Please try again";
	Class<?>[] groups() default{};
	Class<? extends Payload>[] payload() default {};
	
}
