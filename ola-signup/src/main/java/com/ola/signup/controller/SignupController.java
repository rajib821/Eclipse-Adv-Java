 package com.ola.signup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignupController {

	@RequestMapping(value = "/viewSignup", method = RequestMethod.GET)	// Or @GetMapping(/viewSignup)  -> use get reading or showing the data
	public ModelAndView displaySignupPage() {
		
		System.out.println("SignupController.displaySignupPage()");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("signup");
		
		return mv;
	}
	
	
	
// Or @RequestMapping(value = "/viewSignup", method = RequestMethod.POST)
	@PostMapping("/signup")				// Use POST for sending/saving data
	public ModelAndView doSignup(@RequestParam("name") String name, @RequestParam("mobile") String mobile, @RequestParam("email") String email ) {
		
		System.out.println("SignupController.doSignup()");
		System.out.println("Rcv data from the form submission  Name: "+name+" ,Mob no: "+mobile+" ,Enail :"+email);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("confirmation");
		
		return mv;
	}
}
