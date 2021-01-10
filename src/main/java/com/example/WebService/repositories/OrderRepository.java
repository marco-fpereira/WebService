package com.example.WebService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.WebService.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
