package com.example.WebService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.WebService.entities.OrderItem;

@Repository	
public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
	
}
