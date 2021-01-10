package com.example.WebService.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.WebService.entities.Product;
import com.example.WebService.service.ProductService;

@RestController	
@RequestMapping(value = "/products")

public class ProductResource {

	@Autowired
	private ProductService productService;
	 
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		List<Product> u = productService.findAllProducts();
		return ResponseEntity.ok().body(u);
	}
	
	@GetMapping(value = "/{id}") 
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(productService.findById(id));
	}
	
}
