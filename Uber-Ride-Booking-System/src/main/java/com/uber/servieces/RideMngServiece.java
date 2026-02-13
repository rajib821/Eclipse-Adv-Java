package com.uber.servieces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uber.entity.RideMngEntity;
import com.uber.entity.RideStatus;
import com.uber.exception.RideNotAvailable;
import com.uber.repository.RideMngRepository;
import com.uber.request.RideMngReq;

@Service
public class RideMngServiece {
	@Autowired
	RideMngRepository rideMngRepository;

	public String bookNewRide(RideMngReq rideMngReq) {
		RideMngEntity ride = new RideMngEntity();

		ride.setSource(rideMngReq.getSource());
		ride.setDestination(rideMngReq.getDestination());
		ride.setFare(rideMngReq.getFare());
		ride.setDriverId(rideMngReq.getDriverId());
		ride.setRiderId(rideMngReq.getRiderId());
		ride.setStatus(RideStatus.REQUESTED);

		rideMngRepository.save(ride);

		return "Ride Booked ";
	}

	public RideMngEntity fetchById(int id) {
		RideMngEntity entity = rideMngRepository.findById(id).orElse(null);

		if (entity == null) {
			throw new RideNotAvailable("Ride not available ");
		}
		return entity;
	}

	public String updateRideStatus(int id, RideStatus status) {
		RideMngEntity entity = rideMngRepository.findById(id).orElse(null);

		if (entity == null) {
			return "no id found, please check ";
		}

		entity.setStatus(status);
		rideMngRepository.save(entity);
		return "Status Updated ";
	}

	public String cancelRide(int id) {
		RideMngEntity entity = rideMngRepository.findById(id).orElse(null);

		if (entity == null) {
			return "ride not found, please check ";
		}
		rideMngRepository.deleteById(id);
		
		return "Ride canceled for this id :- "+id;
	}
	
	public List<RideMngEntity> fetchAllRidesForRider(int id) {
		List<RideMngEntity> entity = (List<RideMngEntity>) rideMngRepository.findByriderId(id);
		if(entity.isEmpty()) {
			throw new RideNotAvailable("No rider found ");
		}
		
		return entity;
	}

}
