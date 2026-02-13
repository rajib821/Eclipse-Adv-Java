package com.uber.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uber.entity.RideMngEntity;
import com.uber.entity.RideStatus;
import com.uber.request.RideMngReq;
import com.uber.servieces.RideMngServiece;

@RestController
@RequestMapping("uber")
public class RideManagementController {
	@Autowired
	RideMngServiece rideMngServiece;
	
	@PostMapping("/bookride")
	public String bookNewRide(@RequestBody RideMngReq rideMngReq) {
		return rideMngServiece.bookNewRide(rideMngReq);
		
	}
	
	@GetMapping("ridemng/{id}")
	public RideMngEntity findDetails(@PathVariable("id") int id) {
		return rideMngServiece.fetchById(id);
	}
	
	@PutMapping("staupdate/{id}/{status}")
	public String updateRideStatus(@PathVariable("id") int id, @PathVariable("status") RideStatus status) {
		return rideMngServiece.updateRideStatus(id, status);
	}
	
	@DeleteMapping("cancelRide/{id}")
	public String cancelRide(@PathVariable("id") int id) {
		return rideMngServiece.cancelRide(id);
	}
	
	@GetMapping("fetchRiderForRides/{id}")
	public List<RideMngEntity> fetchAllRidesForRider(@PathVariable("id") int id){
		return rideMngServiece.fetchAllRidesForRider(id);
	}
}
