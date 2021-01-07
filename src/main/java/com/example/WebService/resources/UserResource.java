package com.example.WebService.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.WebService.entities.User;

@RestController		// Defining that this class is a web resource that is implemented by a rest controller
@RequestMapping(value = "/users")	//Giving a name to the resource and its path

public class UserResource {

	// this method is an end point to access the users. The type ResponseEntity is a specific type to return responses from web requests 
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "Maria", "maria@gmail.com", "91234-5678", "myPassword");
		return ResponseEntity.ok().body(u);	// this type of return is used to return the response successfully in the HTTP
	}
	
}
