package com.zavada.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

import com.zavada.domain.EditUserRequest;
import com.zavada.entity.Course;
import com.zavada.entity.User;
import com.zavada.mapper.UserMapper;
import com.zavada.service.CountryService;
import com.zavada.service.CourseService;
import com.zavada.service.UserService;
import com.zavada.service.utils.FilesUtils;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/user")
@SessionAttributes({"editUserModel", "countries"})
@Slf4j
public class UserController {

	private UserService userservice;
	private CountryService countryService;
	private CourseService courseService;
		
	@Autowired
	public UserController(UserService userservice, CountryService countryService, CourseService courseService) {
		this.userservice = userservice;
		this.countryService = countryService;
		this.courseService = courseService;
	}

	@GetMapping("/{userId}/profile")
	public String showUserProfile(@PathVariable("userId") int id, Model model) throws IOException {
		log.debug("Show PROFILE by user id: " + id);
		User user = userservice.findUserById(id);
		user.setPassword(""); // clean password string
		
		String image = FilesUtils.getImage("user_" + user.getId(), user.getUserImage());
		model.addAttribute("userModel", user);
		model.addAttribute("profileImage", image);
		
		List<Course> coursesByTeacher = courseService.findAllCoursesByTeacher(user);
		
		for(int i = 0; i < coursesByTeacher.size(); i++) {
			String courseImage = coursesByTeacher.get(i).getCourseImage();
			coursesByTeacher.get(i).setCourseImage(FilesUtils.getImage("course_" + coursesByTeacher.get(i).getId(), courseImage));
		}
		
		model.addAttribute("userCourses", coursesByTeacher);
		
		model.addAttribute("title", "User Profile");
		return "user/profile";
	}
	
	@GetMapping("/{userId}/profile/edit")
	public String showEditPage(@PathVariable("userId") int userId, Model model) {
		User user = userservice.findUserById(userId);
		
		model.addAttribute("countries", countryService.findAllCountries());
		model.addAttribute("editUserModel", UserMapper.userToEdit(user));
		
		model.addAttribute("title", "Edit profile");
		return "user/edit";
	}

	@PostMapping("/{userId}/profile/edit")
	public String saveEditPage(
			@Valid @ModelAttribute("editUserModel") EditUserRequest request, 
			@PathVariable("userId") int userId, Model model, BindingResult result,
			@RequestParam("profileImage") MultipartFile file) throws IOException {
		
		if(result.hasErrors() || file.isEmpty()) {
			return "user/edit";
		}
		User user = UserMapper.editToUser(request);
		user.setUserImage(file.getOriginalFilename());
		userservice.saveUser(user);
		FilesUtils.createImage("user_" + user.getId(), file);
		
		return "redirect:/user/" + userId + "/profile";
	}
	
	
	
	@GetMapping("/logout")
	public String userLogout(Model model, HttpServletRequest request, HttpServletResponse response) {
		// @CookieValue("user_id") String cookie
				
		Cookie cookie = new Cookie("user_id", null);
		cookie.setValue(null);
		cookie.setPath("/");
		cookie.setMaxAge(0);
		response.addCookie(cookie);	
		return "redirect:/login";
	}
	
}
