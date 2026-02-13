package com.zepto.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zepto.request.PaymentReq;

@RestController
public class PaymentController {
	
	@PostMapping("/zepto/processpayment")
	public String payment(@RequestBody PaymentReq paymentReq) {
		System.out.println("amount :- "+paymentReq.getAmount());
		return "Payment Done";
	}
}
