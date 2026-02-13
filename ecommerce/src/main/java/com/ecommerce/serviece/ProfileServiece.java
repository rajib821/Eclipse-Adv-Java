package com.ecommerce.serviece;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.ProfileEntity;
import com.ecommerce.exception.UserAlreadyExist;
import com.ecommerce.repository.ProfileRepository;
import com.ecommerce.request.ProfileRequest;

@Service
public class ProfileServiece {
	
	@Autowired
	ProfileRepository profileRepository;
	
	public int creatProfile(ProfileRequest request) {
		System.out.println("ProfileServiece.creatProfile().....");
		ProfileEntity entity = new ProfileEntity();
		entity.setName(request.getName());
		entity.setEmail(request.getEmail());
		entity.setMobile(request.getMobile());
		
		ProfileEntity emailProfileEntity = profileRepository.getProfileByEmail(request.getEmail());
		
		Integer response = null;
		if(emailProfileEntity==null) {
		response = profileRepository.submitProfile(entity);
		
		} else {
			throw new UserAlreadyExist("Plz check user already exist    code :- 001C  !!!");
		}
		
		
		
		
		return response;
	}
//	// show all users
//	public List<ProfileEntity> gettAllUsers(){
//		return profileRepository.getAllProfile();
//	}
//	//edit or update profile
//	public ProfileEntity getProfile(Integer id) {
//		return profileRepository.getProfile(id);
//	}
//	public void editProfile(ProfileEntity entity) {
//		profileRepository.editProfile(entity);
//	}
//	// soft delete
//	public void softDelete(Integer id) {
//		profileRepository.softDelete(id);
//	}
}
