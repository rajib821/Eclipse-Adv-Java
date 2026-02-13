package com.zomato.exception;

public class ItemNotFound extends RuntimeException{
	public ItemNotFound(String message) {
		super(message);
	}
}
