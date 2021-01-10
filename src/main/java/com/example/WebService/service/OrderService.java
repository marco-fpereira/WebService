package com.example.WebService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.WebService.entities.Order;
import com.example.WebService.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository OrderRepository;
	
	public List<Order> findAllOrders(){
		return OrderRepository.findAll();
	}
	
	public Order findById(Long id) {
		return OrderRepository.findById(id).get();
	}
}
