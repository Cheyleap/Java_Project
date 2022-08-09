package com.javaproject.controller;

import javax.naming.NameNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaproject.entity.User;
import com.javaproject.repository.UserRepo;
import com.javaproject.service.UserService;
import com.javaproject.service.UserServiceDetails;

@Controller
public class MyController {
	@Autowired
	private UserRepo repo;
	
	@GetMapping("/")
	public String homePage() {
		return "";
	}
	@GetMapping("/login")
	public String login(Model mod) {
		mod.addAttribute("user", new User());
		return "login";
	}
	
	@GetMapping("/register")
	public String register(Model mod) {
		mod.addAttribute("user", new User());
		return "register";
	}
	
	@PostMapping("/process_register")
	public String processRegister(User user) {
		BCryptPasswordEncoder pass=new BCryptPasswordEncoder();
		String passEncoder=pass.encode(user.getPassword());
		user.setPassword(passEncoder);
		repo.save(user);
		return "signin";
	}
	
//	super admin
	
	@PostMapping("/super_admin")
	public String getSuperAdmin() {
		return "super_admin";
	}
	
	// @PostMapping("/management")
	@RequestMapping("/management")
	public String management() {
		return "managerment";
	}
	
}
