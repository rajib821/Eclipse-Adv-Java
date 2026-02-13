package com.blinkit.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blinkit.entity.UserEntity;
import com.blinkit.request.UserRequest;
import com.blinkit.serviece.UserServiece;

@RestController
public class BlinkitController {

	@Autowired
	UserServiece userServiece;
	@GetMapping("genUserData")
	public String UserData(@RequestBody UserRequest userRequest) {
		
//		System.out.println("BlinkitController.userData()::::::::: start");
//		
//		String name= userRequest.getName();
//		String email = userRequest.getEmail();
//		
//		System.out.println("Name :- "+name+" Email :- "+email);
		userServiece.saveProfile(userRequest);
		
//		
		return "User data comes to backend ";
	}
	
	@PostMapping("getAll")
	public List<UserEntity> getAllProfile(){
		return userServiece.getAllProfile();
	}
	
	@PutMapping("users/{id}")
	public UserEntity editProf(@PathVariable("id") Integer id,@RequestBody UserRequest req) {
		UserEntity entity = userServiece.editProfile(id	, req);
		return entity;
	}
	


	
	
	//delete
	@DeleteMapping("usersDelete/{id}")
	public String deleteUser(@PathVariable("id") Integer id) {

	    userServiece.deleteUser(id);
	    return "User deleted successfully";
	}

	
}
