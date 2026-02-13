package com.pharma.password;

import java.util.Random;

public class PasswordGen {
	 public static String generatePassword() {
	        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	        String password = "";
	        Random random = new Random();

	        for (int i = 0; i < 6; i++) {
	            password += chars.charAt(random.nextInt(chars.length()));
	        }
	        return password;
	    }
}
