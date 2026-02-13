package com.ecommerce.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EcExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public String handleException(Exception e, Model model) {
		model.addAttribute("errorMsg", "unable to move next !!!");
		return "error";
		
	}
	
	@ExceptionHandler(UserAlreadyExist.class)
	public String handleException(UserAlreadyExist e, Model model) {
		model.addAttribute("errorMsg", "Sorry user already exist !!!");
		return "error";
		
	}
}
