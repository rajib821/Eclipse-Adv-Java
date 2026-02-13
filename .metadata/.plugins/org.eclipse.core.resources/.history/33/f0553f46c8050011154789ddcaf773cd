package com.ecomerce.order.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ecomerce.order.dto.OrderItemRequestDto;
import com.ecomerce.order.dto.OrderItemResponseDto;
import com.ecomerce.order.dto.OrderRequestDto;
import com.ecomerce.order.dto.OrderResponseDto;
import com.ecomerce.order.entity.OrderItem;
import com.ecomerce.order.entity.Orders;
import com.ecomerce.order.enums.OrderStatus;
import com.ecomerce.order.repository.IOrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements IOrderService{
	
	private final IOrderRepository orderRepo;
	
	@Override
	public OrderResponseDto placeOrder(OrderRequestDto request) {
              
		         Orders order=new Orders();
		         order.setUserId(request.getUserId());
		         order.setStatus(OrderStatus.PLACED);
		         List<OrderItem>orderItems=new ArrayList<>();
		         double totalAmount=0.0;
		         
		         for(OrderItemRequestDto itemDto:request.getItems())
		         {
		        	 OrderItem item=new OrderItem();
		        	 item.setProductId(itemDto.getProductId());
		        	 item.setQuantity(itemDto.getQuantity());
		        	 item.setPrice(itemDto.getPrice());
		        	 item.setOrder(order);
		        	  
		        	 totalAmount+=itemDto.getPrice()*itemDto.getQuantity();
		        	 orderItems.add(item);
		         }
                 
		         order.setItems(orderItems);
		         order.setTotalAmount(totalAmount);
		         
		       Orders savedOrder= orderRepo.save(order);
		
		return  mapToOrderResponse(savedOrder);
	}
	
	public OrderResponseDto mapToOrderResponse(Orders order)
	{
		OrderResponseDto response=new OrderResponseDto();
		response.setOrderid(order.getId());
		response.setStatus(order.getStatus());
		response.setUserId(order.getUserId());
		response.setTotalAmount(order.getTotalAmount());
		 	
		List<OrderItemResponseDto>itemResponse=new ArrayList<>();
		for(OrderItem item:order.getItems())
		{
		   OrderItemResponseDto itemDto=new OrderItemResponseDto();
		   
		   itemDto.setProductId(item.getProductId());
		   itemDto.setPrice(item.getPrice());
		   itemDto.setQuantity(item.getQuantity());
		   itemResponse.add(itemDto);
			
		}
		response.setItems(itemResponse);
		
		return response;
	}

}
