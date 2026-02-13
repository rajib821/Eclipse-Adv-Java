package com.uber.exception;

public class RideNotAvailable extends RuntimeException {
	public RideNotAvailable(String message) {
		super(message);
	}
}
