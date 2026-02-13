package com.uber.servieces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uber.entity.DriverEntity;
import com.uber.exception.DriverNotFound;
import com.uber.repository.DriverRepository;
import com.uber.request.DriverRequest;

@Service
public class DriverServiece {
	@Autowired
	DriverRepository driverRepository;
	
	public String regDriver(DriverRequest driverRequest) {
		DriverEntity entity = new DriverEntity();
		
		entity.setName(driverRequest.getName());
		entity.setPhone(driverRequest.getPhone());
		entity.setVehicleNumber(driverRequest.getVehicleNumber());
		entity.setAvailability(driverRequest.getAvailability());
		entity.setCurrentLocation(driverRequest.getCurrentLocation());
		
		driverRepository.save(entity);
		return " New driver registered ";
	}
	
	public String updateDriverAvailability(int id, String available) {
		
		int response = driverRepository.availabilityById(id, available);
		if(response == 0) {
			return "Driver not found for this id";
		}
		return "Availability updated successfully ";
	}
	
	public DriverEntity fetchDriverDetails(int id) {
		DriverEntity driver = driverRepository.findById(id).orElse(null);
		if(driver == null) {
			throw new DriverNotFound("Driver not found for this id "+id);
		}
		return driver;
	}

	public String deleteDrivere(int id) {
		DriverEntity driver = driverRepository.findById(id).orElse(null);
		if(driver == null) {
			return "Driver not found for this id :- "+id;
		}
		driverRepository.deleteById(id);
		return "Driver deleted successfully for this id :- "+id;
	}
}
