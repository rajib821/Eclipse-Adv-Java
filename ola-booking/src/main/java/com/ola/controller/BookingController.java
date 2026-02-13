package com.ola.controller;

import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ola.pojo.BookingRequest;

@Controller
public class BookingController {

	@RequestMapping("viewBooking")
	public ModelAndView displayBookingPage() {
		System.out.println("BookingController.viewBookingPage()........");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("booking");
		return mv;
	}

	@RequestMapping("bookMyRide")
	public String bookRide(@ModelAttribute BookingRequest bookingRequest, Model model) {
		String source = bookingRequest.getSource();
		String destination = bookingRequest.getDestination();
		String rideType = bookingRequest.getRideType();
		System.out.println("Booking request information : [ " + source + " " + destination + " " + rideType + " ]");
		// 🔹 Generate random booking code
		String bookingCode = UUID.randomUUID().toString().replace("-", "").substring(0, 6).toUpperCase();
		System.out.println("Booking Confirmation Code : " + bookingCode);
		
		// sending Booking Confirmation Code to the browser
		model.addAttribute("bookingConfirmationCode", bookingCode);   // model.addAttribute(key, value)
		return "bookingConfirmation";
	}
}
