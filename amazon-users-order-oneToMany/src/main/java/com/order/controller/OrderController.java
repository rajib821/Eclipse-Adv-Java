package com.order.controller;
import com.order.serviece.impl.OrderServiece;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.order.entity.OrderEntity;
import com.order.request.OrderRequest;
import com.order.serviece.IOrderServiece;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderServiece orderServiece;
	@Autowired
	IOrderServiece iOrderServiece;

    OrderController(OrderServiece orderServiece) {
        this.orderServiece = orderServiece;
    }
	
	@PostMapping("/place")
	public OrderEntity placeOrder(@RequestBody OrderRequest orderRequest) {
		return iOrderServiece.createOrder(orderRequest);
	}
	
	@GetMapping("/fetch")
	public List<OrderEntity> fetchOrder(@RequestParam int orderId){
		return orderServiece.fetchOrder(orderId);
	}
	
	@GetMapping("/display")
	public int display() {
		return orderServiece.displayAll();
		
	}
}
