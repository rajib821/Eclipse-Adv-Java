package com.pagination.serviece;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pagination.entity.UserEntity;
import com.pagination.repository.UserRepository;
import com.pagination.request.UserReq;

@Service
public class UserServiece {
	@Autowired
	UserRepository userRepo;
	
	public int createUser(UserReq userReq) {
		UserEntity entity = new UserEntity();
		entity.setFname(userReq.getFname());
		entity.setLname(userReq.getLname());
		
		userRepo.save(entity);
		
		return  entity.getId();
	}
	
	
	// 	PAGINATION
	public Page<UserEntity> showUsers(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		return userRepo.findAll(pageable);
	}
	
	public String updateLname(int id, String lName) {
		UserEntity entity = userRepo.findById(id).orElse(null);
		if(entity==null) {
			return "No id found";
		}
		
		entity.setLname(lName);
		
		userRepo.save(entity);
		return "Update successfully "+entity.getId()+" "+entity.getFname()+" "+entity.getLname();
	} 
}
