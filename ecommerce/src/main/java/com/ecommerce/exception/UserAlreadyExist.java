package com.ecommerce.exception;

public class UserAlreadyExist extends RuntimeException {
	public UserAlreadyExist(String msg) {
		super(msg);
	}
}
