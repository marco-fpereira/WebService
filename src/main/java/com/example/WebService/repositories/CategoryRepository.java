package com.example.WebService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.WebService.entities.Category;

@Repository	
public interface CategoryRepository extends JpaRepository<Category, Long>{
	
}
