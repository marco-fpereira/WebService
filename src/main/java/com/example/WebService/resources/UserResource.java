package com.example.WebService.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.WebService.entities.User;
import com.example.WebService.service.UserService;

@RestController		// Defining that this class is a web resource that is implemented by a rest controller
@RequestMapping(value = "/users")	//Giving a name to the resource and its path

public class UserResource {

	@Autowired
	private UserService userService;
	
	// this method is an end point to access the users. The type ResponseEntity is a specific type to return responses from web requests 
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> u = userService.findAllUsers();
		return ResponseEntity.ok().body(u);	// this type of return is used to return the response successfully in the HTTP
	}
	
	// in this case, will be passed the user id on URL, so it's done to show that URL will have a parameter
	@GetMapping(value = "/{id}") 
	// "PathVariable" is needed to show that the 'id' received at the RestController endpoint is the passed in the URL
	public ResponseEntity<User> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(userService.findById(id));
	}
	
}
