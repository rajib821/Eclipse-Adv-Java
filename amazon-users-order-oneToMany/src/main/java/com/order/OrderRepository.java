package com.order;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.order.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer>{
	
	public List<OrderEntity> findByOrderId(int orderId);
	
	@Query(" SELECT o FROM OrderEntity o JOIN FETCH o.items ")      // this JOIN FETCH solve N+1 problem.
	public List<OrderEntity> findAllWithItems();
}
