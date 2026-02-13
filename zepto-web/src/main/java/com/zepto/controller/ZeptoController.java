package com.zepto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zepto.controller.pojo.SignupInfo;

@Controller
public class ZeptoController {
	@RequestMapping("/signup")
	public ModelAndView displaySignupPage() {
		System.out.println("I am inside displaySignupPage.....");
		ModelAndView mv = new ModelAndView();
//		mv.setViewName("displaySignup");
		return mv;
	}
	@RequestMapping("signupInfo")
	public String displatData(@ModelAttribute SignupInfo info) {
		System.out.println("Name : "+info.getName()+" , Email : "+info.getEmail());
		return "confirmation";
	}
}
