package com.ecomerce.service.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ecomerce.dto.request.UserRequest;
import com.ecomerce.dto.response.UserResponse;
import com.ecomerce.entity.UserEntity;
import com.ecomerce.repository.UserRepository;
import com.ecomerce.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;  

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public String userRegistered(UserRequest userRequest){
		String autoPassword = generatePassword();

		UserEntity user = new UserEntity();
		user.setName(userRequest.getName());
		user.setEmail(userRequest.getEmail());
		user.setPassword(autoPassword);

		userRepository.save(user);

		return "Registered successfully & password :- " + autoPassword;
	}

	private String generatePassword() {
		return UUID.randomUUID().toString().replace("-", "").substring(0, 8);
	}

	
	@Override
	public UserResponse loginUser(String email, String password) {

	    UserEntity user = userRepository.findByEmail(email)
	            .orElseThrow(() -> new RuntimeException("User not found"));

	    if (!user.getPassword().equals(password)) {
	        throw new RuntimeException("Invalid password");
	    }

	    UserResponse userRes = new UserResponse();
	    userRes.setId(user.getId());
	    userRes.setName(user.getName());
	    userRes.setEmail(user.getEmail());

	    return userRes;
	}

}
