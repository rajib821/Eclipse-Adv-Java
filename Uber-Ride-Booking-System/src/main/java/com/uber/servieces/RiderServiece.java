package com.uber.servieces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uber.entity.RiderEntity;
import com.uber.exception.RiderNotAvailable;
import com.uber.repository.RiderRepository;
import com.uber.request.RiderRequest;

@Service
public class RiderServiece {
	@Autowired
	RiderRepository riderRepository;
	
	public String createNewRider(RiderRequest riderRequest) {
		RiderEntity entity = new RiderEntity();
		
		entity.setName(riderRequest.getName());
		entity.setEmail(riderRequest.getEmail());
		entity.setPhone(riderRequest.getPhone());
		entity.setCurrentLocation(riderRequest.getCurrentLocation());
		
		riderRepository.save(entity);
		return " New rider created";
	}
	
	public RiderEntity fetchRiderById(int id) {
		RiderEntity rider = riderRepository.findById(id).orElse(null);
		if(rider == null) {
			throw new RiderNotAvailable("Rider not fetched ");
		}
		return rider;
	}
	
	public String updateRider(int id, RiderRequest riderRequest) {
		RiderEntity riderId = riderRepository.findById(id).orElse(null);
		if(riderId == null) {
			
			return "No rider available in this id :- "+id;
		}
		riderId.setName(riderRequest.getName());
		riderId.setEmail(riderRequest.getEmail());
		riderId.setPhone(riderRequest.getPhone());
		riderId.setCurrentLocation(riderRequest.getCurrentLocation());
		
		riderRepository.save(riderId);
		
		return "Rider updated successfully";
	}
	
	public String deleteRider(int id) {
		RiderEntity riderExist = riderRepository.findById(id).orElse(null);
		if(riderExist == null) {
			return "Rider not availbe for this id :- "+id;
		}
		riderRepository.deleteById(id);
		return "id :- "+id+" deleted successfully";
	}
}
