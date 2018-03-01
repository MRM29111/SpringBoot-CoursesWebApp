package com.zavada.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.zavada.domain.CourseRequest;
import com.zavada.entity.Course;
import com.zavada.entity.User;
import com.zavada.entity.enumeration.Category;
import com.zavada.mapper.CourseMapper;
import com.zavada.service.CourseService;
import com.zavada.service.UserService;
import com.zavada.service.utils.FilesUtils;

@Controller
@RequestMapping("/course")
@SessionAttributes({"courseModel", "categories", "user"})
public class CourseController {

	private CourseService courseService;
	private UserService userService;

	@Autowired
	public CourseController(CourseService courseService, UserService service) {
		this.courseService = courseService;
		this.userService = service;
	}
	
	@GetMapping("/{userId}/create")
	public String showCreateCoursePage(@PathVariable("userId") int userId, Model model) {
		CourseRequest courseRequest = new CourseRequest();
		User user = userService.findUserById(userId);
		courseRequest.setUser(user);
		
		model.addAttribute("courseModel", courseRequest);
		model.addAttribute("categories", Category.values());
		return "course/create";
	}
	
	@PostMapping("/{userId}/create")
	public String createCoursePage(@PathVariable("userId") int userId,
			@Valid @ModelAttribute("courseModel") CourseRequest request, BindingResult result, 
			@RequestParam("courseFileImage") MultipartFile file) throws IOException {
		
		if(result.hasErrors() || file.isEmpty()) {
			return "course/create";
		}
		
		Course course = CourseMapper.toCourse(request);
		course.setCourseImage(file.getOriginalFilename());
		courseService.saveCourse(course);
		FilesUtils.createFolder("course_" + course.getId());
		FilesUtils.createImage("course_" + course.getId(), file);
		return "redirect:/";
	}
	
	@GetMapping("/courses")
	public String showCoursesList(Model model) {
		model.addAttribute("coursesList", courseService.findAllCourses());
		return "course/courses";
	}
	
}
