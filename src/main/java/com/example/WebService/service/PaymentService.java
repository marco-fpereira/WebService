package com.example.WebService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.WebService.entities.Payment;
import com.example.WebService.repositories.PaymentRepository;


@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;
	
	public List<Payment> findAllPayments(){
		return paymentRepository.findAll();
	}
	
	public Payment findById(Long id) {
		return paymentRepository.findById(id).get();
	}
}
