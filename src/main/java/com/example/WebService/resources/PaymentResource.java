package com.example.WebService.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.WebService.entities.Payment;
import com.example.WebService.service.PaymentService;

@RestController	
@RequestMapping(value = "/payments")
public class PaymentResource {

	@Autowired
	private PaymentService paymentService;
	 
	@GetMapping
	public ResponseEntity<List<Payment>> findAll(){
		List<Payment> u = paymentService.findAllPayments();
		return ResponseEntity.ok().body(u);
	}
	
	@GetMapping(value = "/{id}") 
	public ResponseEntity<Payment> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(paymentService.findById(id));
	}
	
}
