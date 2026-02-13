package com.blinkit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BlinkitExceptionHandler {
	
	 @ExceptionHandler(UserAlreadyExist.class)
	    public ResponseEntity<String> handleUserAlreadyExist(UserAlreadyExist e) {
	        return ResponseEntity
	                .status(HttpStatus.CONFLICT)
	                .body(e.getMessage());
	    }

	    @ExceptionHandler(RuntimeException.class)
	    public ResponseEntity<String> handleRuntime(RuntimeException e) {
	        return ResponseEntity
	                .status(HttpStatus.BAD_REQUEST)
	                .body(e.getMessage());
	    }

	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<String> handleException(Exception e) {
	        e.printStackTrace(); // 🔥 VERY IMPORTANT
	        return ResponseEntity
	                .status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body("Internal Server Error");
	    }
	
//	@ExceptionHandler(Exception.class)
//	public String exceptionHandler(Exception e) {
//		
//		return "unable to procced !!!";
//	}
//	
//	@ExceptionHandler(UserAlreadyExist.class)
//	public String exceptionHandler(UserAlreadyExist e) {
//		
//		return "This email already exist please change the email !!!";
//	}
}
