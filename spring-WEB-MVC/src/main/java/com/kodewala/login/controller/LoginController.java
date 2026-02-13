package com.kodewala.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@RequestMapping("login")
	public ModelAndView doLogin() {
		System.out.println("LoginController.doLogin()");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login"); // response will be sent to this page
		mv.addObject("msg", "Welcome Rajib");

		return mv;
	}
}
