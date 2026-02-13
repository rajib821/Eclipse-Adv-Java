package com.pharma.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PharmaExceptionHandler {
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e) {
		return "!!!unable to proceed !!! "+e.getMessage();
	}
	
//	@ExceptionHandler(UserAlreadyExist.class)
//	public ResponseEntity<String> exceptionHandler(UserAlreadyExist e) {
//		return new ResponseEntity<String>("!!! User already exist !!! "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
//	}
	
	@ExceptionHandler(UserAlreadyExist.class)
	public ResponseEntity<String> exceptionHandler( UserAlreadyExist u){
		return new ResponseEntity<String>("!!! User already exist !!1"+u.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
