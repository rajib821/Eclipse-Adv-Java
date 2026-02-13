package com.ecomerce.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomerce.dto.request.UserRequest;
import com.ecomerce.dto.response.UserResponse;
import com.ecomerce.service.UserService;

import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping("/ecommerce")
public class UserController {
	
	private final UserService userService;
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping("/register")
	public String userRegister(@Valid @RequestBody UserRequest userRequest) {
		return userService.userRegistered(userRequest);
	}
	
	@GetMapping("/login/{email}/{password}")
	public UserResponse loginUser(@PathVariable("email") String email, @PathVariable("password") String password) {
		return userService.loginUser(email, password);
	}
}
