package com.zomato.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ZomatoExceptionHandler {
	
	  @ExceptionHandler(Exception.class)
	    public ResponseEntity<String> handleGeneralException(Exception e) {
	        return new ResponseEntity<>("Unable to proceed: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	
	@ExceptionHandler(ItemNotFound.class)
	public ResponseEntity<String> exceptionHandle(ItemNotFound e) {
		return new ResponseEntity<String>("Item not found "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}
