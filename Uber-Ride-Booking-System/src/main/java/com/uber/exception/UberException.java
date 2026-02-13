package com.uber.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UberException {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> exceptionHandler(Exception e){
		return new ResponseEntity<String>("!!! unable to proceed !!!"+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(RiderNotAvailable.class)
	public ResponseEntity<String> exceptionHandler(RiderNotAvailable e){
		return new ResponseEntity<String>("!!! unable to find rider !!!"+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(DriverNotFound.class)
	public ResponseEntity<String> exceptionHandler(DriverNotFound e){
		return new ResponseEntity<String>("!!! unable to find driver !!!"+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(RideNotAvailable.class)
	public ResponseEntity<String> exceptionHandler(RideNotAvailable e){
		return new ResponseEntity<String>("!!! unable to find ride !!!"+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
