package com.blinkit.serviece;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blinkit.entity.ProfileEntity;
import com.blinkit.exception.UserAlreadyExist;
import com.blinkit.repository.ProfileRepository;
import com.blinkit.request.ProfileRequest;

@Service
public class ProfileServiece {

	@Autowired
	ProfileRepository profileRepository;

	public void submitProfile(ProfileRequest profileRequest) throws UserAlreadyExist {

		ProfileEntity emailExist = profileRepository.getProfileFromMail(profileRequest.getEmail());
		if (emailExist != null) {
			throw new UserAlreadyExist("Plz check email...");
		} else {
			ProfileEntity profileEntity = new ProfileEntity();
			profileEntity.setEmail(profileRequest.getEmail());
			profileEntity.setMobile(profileRequest.getMobile());
			profileRepository.saveProfile(profileEntity);
		}
	}
	
	public List<ProfileEntity> getAllUssers(){
		return profileRepository.getAllUsers();
	}
}
