package com.uber.exception;

public class RiderNotAvailable extends RuntimeException {
	public RiderNotAvailable(String message) {
		super(message);
	}
}
