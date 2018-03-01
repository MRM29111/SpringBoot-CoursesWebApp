package com.zavada.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zavada.service.CourseService;

@Component
public class CheckIfCourseTitleExistsValidator implements ConstraintValidator<CheckIfCourseTitleExists, String> {

	@Autowired private CourseService courseService;

	@Override
	public void initialize(CheckIfCourseTitleExists constraintAnnotation) {

	}

	@Override
	public boolean isValid(String title, ConstraintValidatorContext context) {
		
		return courseService.findCourseByTitle(title) == null ? true : false;
	}

}
