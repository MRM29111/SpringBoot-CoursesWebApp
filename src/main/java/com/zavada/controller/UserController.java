package com.zavada.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zavada.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {

	@Autowired private UserService userservice;
	
	@GetMapping("/{userId}/profile")
	public String showUserProfile(@PathVariable("userId") int id, Model model, HttpServletResponse response) {
		log.debug("Show PROFILE by user id: " + id);
//		User user = userservice.findUserById(id);
//		user.setPassword("");
		
		Cookie cookie = new Cookie("user_id", id+"");
		cookie.setMaxAge(24 * 60 * 60);
		cookie.setPath("/");
		response.addCookie(cookie);
		
		return "user/profile";
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
