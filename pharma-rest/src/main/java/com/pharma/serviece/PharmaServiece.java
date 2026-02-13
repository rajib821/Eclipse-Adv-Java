package com.pharma.serviece;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharma.entity.PharmaUserEntity;
import com.pharma.exception.UserAlreadyExist;
import com.pharma.password.PasswordGen;
import com.pharma.repository.PharmaRepository;
import com.pharma.request.UserRequest;

@Service
public class PharmaServiece {
	@Autowired
	PharmaRepository pharmaRepository;

	public String createProfile(UserRequest userRequest) {
	
		PharmaUserEntity uniquEmail = pharmaRepository.getProfileFromEmail(userRequest.getEmailId());
		if (uniquEmail != null) {
			throw new UserAlreadyExist("This email already exist");
		} 
		PharmaUserEntity userEntity = new PharmaUserEntity();
			userEntity.setName(userRequest.getName());
			userEntity.setEmailId(userRequest.getEmailId());

		// Password
		String password = PasswordGen.generatePassword();
		userEntity.setPassword(password);

		pharmaRepository.createUserProfile(userEntity);
		return password;
	}
	
	public PharmaUserEntity login(String email, String password) {
		PharmaUserEntity user = pharmaRepository.login(email, password);
		return user;
	}
}
