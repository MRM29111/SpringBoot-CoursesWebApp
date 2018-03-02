package com.zavada.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.zavada.domain.LoginRequest;
import com.zavada.domain.RegisterRequest;
import com.zavada.entity.User;
import com.zavada.mapper.UserMapper;
import com.zavada.service.UserService;
import com.zavada.service.utils.FilesUtils;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BaseController {

	@Autowired private UserService userService;
	
	@GetMapping("/")
	public String showHome() {
		log.debug("Show HOME page");
		return "home";
	}
		
	@GetMapping("/register")
	public String showRegister(Model model) {
		log.debug("Show REGISTER page");
		model.addAttribute("userModel", new RegisterRequest());
		
		return "register";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("userModel") RegisterRequest request, BindingResult result) {
		log.debug("Register: " + request.getEmail());
		
		if(result.hasErrors()) {
			return "register";
		}
		
		User user = UserMapper.registerToUser(request);
		userService.saveUser(user);

		FilesUtils.createFolder("user_" + user.getId());
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String showLogin(Model model) {
		model.addAttribute("userModel", new LoginRequest());
		return "login";
	}
	
//	@PostMapping("/login")
//	public String login(@Valid @ModelAttribute("userModel") LoginRequest request, BindingResult result, HttpServletResponse response) {
//		log.debug("Login : " + request.getEmail());
//		if(result.hasErrors()) {
//			return "login";
//		}
//		User user = userService.findUserByEmail(request.getEmail());
//		
//		Cookie cookie = new Cookie("user_id", user.getId()+"");
//		cookie.setMaxAge(24 * 60 * 60);
//		cookie.setPath("/");
//		response.addCookie(cookie);
//		return "redirect:/user/" + user.getId() + "/profile";
//	}
		
}
