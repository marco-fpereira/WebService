package com.example.WebService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.WebService.entities.Payment;

@Repository	
public interface PaymentRepository extends JpaRepository<Payment, Long>{
	
}
