package com.zavada.mapper;

import com.zavada.domain.CourseRequest;
import com.zavada.entity.Course;

public interface CourseMapper {

	public static Course toCourse(CourseRequest request) {
		Course course = new Course();
		course.setTitle(request.getTitle());
		course.setDescription(request.getDescription());
		course.setPrice(request.getPrice());
		course.setUser(request.getUser());
		course.setCategory(request.getCategory());
		return course;
	}
		
}
