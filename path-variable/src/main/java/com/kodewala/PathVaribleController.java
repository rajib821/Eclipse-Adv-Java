package com.kodewala;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PathVaribleController {
	
	@RequestMapping("/knowAbountStatus/{id}")
	public String knowStatus(@PathVariable("id") int id) {
		System.out.println("PathVaribleController.knowStatus().......id rcv as a path-variable ... id = "+id);
		
		return "statusPage";
		
	}
}
