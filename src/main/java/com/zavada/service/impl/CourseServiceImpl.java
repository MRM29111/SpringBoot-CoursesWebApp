package com.zavada.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zavada.entity.Course;
import com.zavada.entity.User;
import com.zavada.repository.CourseRepository;
import com.zavada.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired private CourseRepository courseRepository;

	@Override
	public void saveCourse(Course course) {
		courseRepository.save(course);
	}

	@Override
	public Course findCourseByTitle(String title) {
		return courseRepository.findCourseByTitle(title);
	}

	@Override
	public Course findCourseById(int id) {
		return courseRepository.findOne(id);
	}

	@Override
	public List<Course> findAllCourses() {
		return courseRepository.findAll();
	}

	@Override
	public List<Course> findAllCoursesByTeacher(User user) {
		return courseRepository.findAllCoursesByTeacher(user.getId());
	}
	
	
	
}
