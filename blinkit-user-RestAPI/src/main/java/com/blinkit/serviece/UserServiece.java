package com.blinkit.serviece;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blinkit.entity.UserEntity;
import com.blinkit.exception.UserAlreadyExist;
import com.blinkit.repository.UserRepository;
import com.blinkit.request.UserRequest;

import jakarta.transaction.Transactional;

@Service
public class UserServiece {

	@Autowired
	UserRepository userRepository;

	public void saveProfile(UserRequest request) {

		UserEntity emailCheck = userRepository.getProfileFromEmail(request.getEmail());
		if (emailCheck != null) {
			throw new UserAlreadyExist("Check your email !!!! ");
		} else {
			UserEntity userEntity = new UserEntity();
			userEntity.setName(request.getName());
			userEntity.setEmail(request.getEmail());
			userRepository.saveProfile(userEntity);
		}
	}

	public List<UserEntity> getAllProfile() {
		return userRepository.getAllProfile();
	}

	// get profile for update
	public UserEntity editProfile(Integer id, UserRequest request) {

		// 1️ Fetch existing user
		UserEntity user = userRepository.getProfile(id);

		// 3️ Update fields
		user.setName(request.getName());
		user.setEmail(request.getEmail());

		// 4️ Save updated entity
		userRepository.editProfile(user);

		return user;

	}

	
	@Transactional
	public void deleteUser(Integer id) {

	    UserEntity user = userRepository.getProfile(id);
	    if (user == null) {
	        throw new RuntimeException("User not found with id: " + id);
	    }

	    userRepository.softDeleteUser(id);
	}


}
