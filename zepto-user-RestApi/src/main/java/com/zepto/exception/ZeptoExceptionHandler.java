package com.zepto.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ZeptoExceptionHandler {
	
	
	@ExceptionHandler(Exception.class)
//	@ResponseBody
	public String exceptionHandler(Exception e) {
	    return "Unable to proceed !!!" +e.getMessage();
	}

	@ExceptionHandler(UserAlreadyExist.class)
//	@ResponseBody
	public String exceptionHandler(UserAlreadyExist e) {
	    return "User already exists !!!";
	}

}
