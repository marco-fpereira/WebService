package com.example.WebService.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.WebService.entities.Order;
import com.example.WebService.service.OrderService;

@RestController	
@RequestMapping(value = "/orders")

public class OrderResource {

	@Autowired
	private OrderService orderService;
	 
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		List<Order> u = orderService.findAllOrders();
		return ResponseEntity.ok().body(u);
	}
	
	@GetMapping(value = "/{id}") 
	public ResponseEntity<Order> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(orderService.findById(id));
	}
	
}
