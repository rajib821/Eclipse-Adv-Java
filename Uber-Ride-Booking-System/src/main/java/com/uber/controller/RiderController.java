package com.uber.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uber.entity.RiderEntity;
import com.uber.request.RiderRequest;
import com.uber.servieces.RiderServiece;

@RestController
@RequestMapping("uber")
public class RiderController {

	@Autowired
	RiderServiece riderServiece;
	
	@PostMapping("/create")
	public String createNewRider(@RequestBody RiderRequest riderRequest) {
		String response = riderServiece.createNewRider(riderRequest);
		return response;
	}
	
	@GetMapping("/fetch/{id}")
	public RiderEntity fetchRiderById(@PathVariable("id") int id) {
		return riderServiece.fetchRiderById(id);
	}
	
	@PutMapping("/update/{id}")
	public String updateRider(@PathVariable("id") int id, @RequestBody RiderRequest riderRequest) {
		return riderServiece.updateRider(id, riderRequest);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteRider(@PathVariable("id") int id) {
		return riderServiece.deleteRider(id);
	}
}
