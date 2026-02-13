package com.flipkart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flipkart.controller.FlipkartController;
import com.flipkart.entity.ProfileEntity;
import com.flipkart.repository.ProfileRepository;
import com.flipkart.request.ProfileRequest;

@Service
public class ProfileService {

	private final FlipkartController flipkartController ;
	
	@Autowired
	ProfileRepository profileRepository;
	
	public ProfileService(FlipkartController flipkartController) {
		this.flipkartController = flipkartController;
	}
	
	public int createprofile(ProfileRequest profileRequest) {
		System.out.println("ProfileService.createprofile():::"+profileRequest.getMobile());
		
		ProfileEntity profileEntity = new ProfileEntity();
		profileEntity.setMobile(profileRequest.getMobile());
		profileEntity.setEmail(profileRequest.getEmail());
		
		Integer response = profileRepository.submitProfile(profileEntity);
		System.out.println("ProfileService.createprofile()............."+response.intValue());
		
		return response;
	}	
	// Call repository method to get all users
	public List<ProfileEntity> getAllProfiles() {
	    return profileRepository.getAllProfiles();
	}
	// update or edit profile
	
	public ProfileEntity getprofile(Integer id) {
		return profileRepository.getProfile(id);
	}
	public void edidProfile(ProfileEntity entity) {
		profileRepository.editProfile(entity);
	}
	
	
	// delete
	
	public void deleteProfile(Integer id) {
	    profileRepository.deleteProfile(id);
	}


}
