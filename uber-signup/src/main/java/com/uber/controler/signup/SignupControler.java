package com.uber.controler.signup;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignupControler {
	
	@RequestMapping("/display-signup")
	public ModelAndView displaySignPage() {
		System.out.println("SignupControler.displaySignPage()");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("uberSignup");
		return mv;
	}
	
	@RequestMapping("/signup")
	public ModelAndView doSignup(@RequestParam("name") String name, @RequestParam("mobile") String mobile, @RequestParam("email") String email) {
		System.out.println("SignupControler.doSignup()");
		ModelAndView mv = new ModelAndView();
		System.out.println("Signup data Name : "+name+" , Mobile : "+mobile+" , Email : "+email);
		mv.setViewName("signup-confirmation");
		return mv;
	}

}
