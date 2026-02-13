package com.zomato.controller;

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

import com.zomato.entity.ZomatoEntity;
import com.zomato.repository.ZomatoRepo;
import com.zomato.request.ZomatoRequest;
import com.zomato.serviece.ZomatoServiece;

@RestController
@RequestMapping("/zomato")
public class ZomatoController {


	@Autowired
	ZomatoServiece zomatoServiece;

    
	
	@PostMapping("/order")
	public String placeOrder(@RequestBody ZomatoRequest zomatoRequest) {
		String response = zomatoServiece.placeOrder(zomatoRequest);
		return response;
	}
	
	@GetMapping("/search/{name}")
	public ZomatoEntity findByName(@PathVariable("name") String name) {
		ZomatoEntity response = zomatoServiece.findByName(name);
		return response;
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable("id") int id) {
		String response = zomatoServiece.deleteFood(id);
		return response;
	}
	@PutMapping("/change/{id}")
	public String changeFood(@PathVariable("id") int id, @RequestBody ZomatoRequest zomatoRequest) {
		String response = zomatoServiece.changeFood(id, zomatoRequest);
		return response;
	}
}
