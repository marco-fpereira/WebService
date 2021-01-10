package com.example.WebService.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.WebService.entities.Category;
import com.example.WebService.service.CategoryService;

@RestController	
@RequestMapping(value = "/categories")

public class CategoryResource {

	@Autowired
	private CategoryService categoryService;
	 
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		List<Category> u = categoryService.findAllCategories();
		return ResponseEntity.ok().body(u);
	}
	
	@GetMapping(value = "/{id}") 
	public ResponseEntity<Category> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(categoryService.findById(id));
	}
	
}
