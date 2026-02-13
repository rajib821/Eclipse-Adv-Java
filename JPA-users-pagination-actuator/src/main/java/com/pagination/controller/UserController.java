package com.pagination.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pagination.entity.UserEntity;
import com.pagination.request.UserReq;
import com.pagination.serviece.UserServiece;

@RestController
@RequestMapping("user")
public class UserController {
//	@Autowired
//	UserServiece userServiece;
	UserServiece userServiece;
	public UserController(UserServiece userServiece) {
		this.userServiece = userServiece;
	}
	
	@PostMapping("userCreate")
	public String createUser(@RequestBody UserReq userReq) {
		return "User id is "+userServiece.createUser(userReq);
	}
	
	@GetMapping("displayUsers")
	public Page<UserEntity> displayUsers(@RequestParam int pageNo, @RequestParam int pageSize) {
		return userServiece.showUsers(pageNo, pageSize);
	}
	@PutMapping("update/{id}/{lName}")
	public ResponseEntity<String> updateLname(@PathVariable int id ,@PathVariable String lName ) {
		
		
		return ResponseEntity.ok().body(userServiece.updateLname(id, lName));
		
	}
}
