package com.uber.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uber.entity.DriverEntity;
import com.uber.request.DriverRequest;
import com.uber.servieces.DriverServiece;

@RestController
@RequestMapping("uber")
public class DriverController {
	
	@Autowired
	DriverServiece driverServiece;
	
	@PostMapping("/regdrive")
	public String registerDriver(@RequestBody DriverRequest driverRequest) {
		return driverServiece.regDriver(driverRequest);
		
	}
	@PostMapping("/drivupdate/{id}/{availability}")
	public String updateDriverAvailability(@PathVariable("id") int id, @PathVariable("availability") String availability) {
		return driverServiece.updateDriverAvailability(id, availability);
	}
	
	@GetMapping("/drivfetch/{id}")
	public DriverEntity fetchDriverDetails(@PathVariable("id") int id) {
		return driverServiece.fetchDriverDetails(id);
	}
	
	@DeleteMapping("/drivdelete/{id}")
	public String deleteDrivere(@PathVariable("id") int id) {
		return driverServiece.deleteDrivere(id);
	}
	
}
