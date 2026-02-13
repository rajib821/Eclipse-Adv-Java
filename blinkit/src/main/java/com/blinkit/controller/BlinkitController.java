package com.blinkit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.blinkit.request.ProfileRequest;
import com.blinkit.serviece.ProfileServiece;

@Controller
public class BlinkitController {
	
	@Autowired
	ProfileServiece profileServiece;
	
	@RequestMapping("displaySignup")
	public ModelAndView displaySignupPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("signupPage");
		return mv;
	}
	@RequestMapping("profileCreation")
	public String CreateAccount(@ModelAttribute ProfileRequest profileRequest) {
		profileServiece.submitProfile(profileRequest);
		return "confirmation";
	}
	// Get all users
	
	public String getAllusers{
		return "allUsers";
	}
}
