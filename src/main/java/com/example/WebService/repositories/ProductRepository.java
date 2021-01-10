package com.example.WebService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.WebService.entities.Product;

@Repository	
public interface ProductRepository extends JpaRepository<Product, Long>{
	
}
