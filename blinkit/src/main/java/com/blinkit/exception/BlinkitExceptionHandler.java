package com.blinkit.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
class BlinkitExceptionHandler {

	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e ,Model model){
		model.addAttribute("errorMessage","Please check unable to proceed .");
		return "error";
	}
	
	@ExceptionHandler(UserAlreadyExist.class)
	public String exceptionHandler(UserAlreadyExist e ,Model model){
		model.addAttribute("errorMessage","This user already exist please check your email !!!");
		return "error";
	}
}
