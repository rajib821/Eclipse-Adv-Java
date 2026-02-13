package com.pharma.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pharma.entity.PharmaUserEntity;
import com.pharma.request.UserRequest;
import com.pharma.serviece.PharmaServiece;

@RestController
public class PharmaController {
	@Autowired
	PharmaServiece pharmaServiece;
	
	@PostMapping("user")
	public String createUserProfile(@RequestBody UserRequest userRequest) {
		String confirmation = pharmaServiece.createProfile(userRequest);
		return confirmation;
	}
	@PostMapping("login")
	public PharmaUserEntity login(  @RequestParam String emailid, @RequestParam String password) {
		PharmaUserEntity entity = pharmaServiece.login(emailid, password);
		
		return entity;
	}
	
}
