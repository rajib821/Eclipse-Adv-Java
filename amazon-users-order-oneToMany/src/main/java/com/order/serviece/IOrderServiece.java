package com.order.serviece;

import org.springframework.stereotype.Service;

import com.order.entity.OrderEntity;
import com.order.request.OrderRequest;

@Service
public interface IOrderServiece {
	public OrderEntity createOrder(OrderRequest orderRequest);
}
