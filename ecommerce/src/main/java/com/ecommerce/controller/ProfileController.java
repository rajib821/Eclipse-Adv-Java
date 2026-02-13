package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.entity.ProfileEntity;
import com.ecommerce.request.ProfileRequest;
import com.ecommerce.serviece.ProfileServiece;

@Controller
public class ProfileController {
	@Autowired
	ProfileServiece serviece;
	
	
	@RequestMapping("displayProfile")
	public ModelAndView viewProfilePage() {
		System.out.println("ProfileController.viewRegpage()");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("account");
		return modelAndView;
	}
	
	@RequestMapping("profileCreate")
	public String createProfile(@ModelAttribute ProfileRequest profileRequest) {
		System.out.println("ProfileController.createProfile().....Name :- "+profileRequest.getName());
		//call  serviece
		int id = serviece.creatProfile(profileRequest);
		System.out.println("ProfileController.createProfile()........id :- "+id);
		return "confirmation";
	}
	
//	// Show all users
//	@RequestMapping("getAllUsers")
//	public ModelAndView getAllUsers() {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("users");
//		mv.addObject("users", serviece.gettAllUsers());
//		return mv;
//	}
//	
//	// update or edit profile
//	
//	@RequestMapping("editForm")
//	public ModelAndView editProfileForm(@RequestParam("id") Integer id) {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("editProfile");
//		
//		ProfileEntity entity = serviece.getProfile(id);
//		mv.addObject("profile", entity);
//		return mv;
//	}
//	
//	@RequestMapping("updateProfile")
//	public String editProfile(@ModelAttribute ProfileEntity entity) {
//		serviece.editProfile(entity);
//		return "redirect:getAllUsers";
//	}
	
//	// soft delete
//	@RequestMapping("deleteProfile")
//	public String softDeleteProfile(@RequestParam("id") Integer id) {
//		serviece.softDelete(id);
//		return "redirect:getAllUsers";
//	}
}
