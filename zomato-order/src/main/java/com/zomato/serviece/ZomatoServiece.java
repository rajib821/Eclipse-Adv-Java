package com.zomato.serviece;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zomato.entity.ZomatoEntity;
import com.zomato.exception.ItemNotFound;
import com.zomato.repository.ZomatoRepo;
import com.zomato.request.ZomatoRequest;

@Service
public class ZomatoServiece {

   
	@Autowired
	ZomatoRepo zomatoRepo;

	public String placeOrder(ZomatoRequest zomatoRequest) {
		ZomatoEntity entity = new ZomatoEntity();
		
		entity.setName(zomatoRequest.getName());
		entity.setQty(zomatoRequest.getQty());
		entity.setPrice(zomatoRequest.getPrice());
		
		ZomatoEntity response = zomatoRepo.save(entity);
		int orderId = response.getId();
		if(orderId > 0) {
			return "Order has been placed, with order id :- "+orderId;
		}
		return "Order not able to proceed , orderId :- "+orderId;
	}
	
	public ZomatoEntity findByName(String name) {
		
		ZomatoEntity response = zomatoRepo.findByNameIgnoreCase(name);
		if(response==null) {
			throw new ItemNotFound(name+" Not present");
		}
		return response;
		
	}
	
	public String deleteFood(int id) {
		ZomatoEntity foodpresent = zomatoRepo.findById(id).orElse(null);
		
		if(foodpresent == null) {
			return " food item not present";
		}
		zomatoRepo.deleteById(id);
		return "Deletd food ";
	}
	public String changeFood(int id,ZomatoRequest zomatoRequest) {
		
		ZomatoEntity entity = zomatoRepo.findById(id).orElse(null);
		if(entity == null) {
			return "This food is not present ";
		}
		
		entity.setName(zomatoRequest.getName());
		entity.setQty(zomatoRequest.getQty());
		entity.setPrice(zomatoRequest.getPrice());
		ZomatoEntity response = zomatoRepo.save(entity);
		return "Food change successfully "+entity.getId()+" "+entity.getName()+" "+entity.getQty()+" "+entity.getPrice();
		
	}
}
