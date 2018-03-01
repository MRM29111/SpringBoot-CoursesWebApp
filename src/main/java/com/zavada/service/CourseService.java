package com.zavada.service;

import java.util.List;

import com.zavada.entity.Course;
import com.zavada.entity.User;

public interface CourseService {

	void saveCourse(com.zavada.entity.Course course);
	
	Course findCourseByTitle(String title);
	
	Course findCourseById(int id);
	
	List<Course> findAllCourses();
	
	List<Course> findAllCoursesByTeacher(User user);
}
