package com.flipkart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.flipkart.entity.ProfileEntity;
import com.flipkart.request.ProfileRequest;
import com.flipkart.service.ProfileService;

@Controller
public class FlipkartController {
	
	@Autowired
	ProfileService profileService;
	
	@RequestMapping("profile")
	public ModelAndView viewProfilePage() {
		System.out.println("FlipkartController.viewProfilePage()");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("profolePage");
		return mv;
		
	}
	
	@PostMapping("profileCreation")
	public String creteProfile(@ModelAttribute ProfileRequest profileRequest) {   //, Model model
		System.out.println("FlipkartController.creteProfile()....;;;;;;;"+profileRequest.getEmail());
		int id = profileService.createprofile(profileRequest);
		System.out.println("FlipkartController.creteProfile().........Id :- "+id);
		
//		model.addAttribute("id", id);
		return "confirmation";
	}
	
	
	// view all users
	@RequestMapping("viewAllUsers")
	public ModelAndView viewAllUsers() {
	    ModelAndView mv = new ModelAndView("users");
	    mv.addObject("users", profileService.getAllProfiles());
	    return mv;
	}
	
	// update or edit profile 
	@RequestMapping("editProfile")
	public ModelAndView editProfileForm(@RequestParam("id") Integer id) {

	    ProfileEntity entity = profileService.getprofile(id);

	    ModelAndView mv = new ModelAndView("editProfile");
	    mv.addObject("profile", entity);
	    return mv;
	}

	@PostMapping("updateProfile")
	public String editProfile(@ModelAttribute ProfileEntity entity) {
		profileService.edidProfile(entity);
		return "redirect:viewAllUsers";

	}
	
	//delete
	@RequestMapping("deleteProfile")
	public String deleteProfile(@RequestParam("id") Integer id) {
	    profileService.deleteProfile(id);
	    return "redirect:viewAllUsers";
	}


}
