package com.example.WebService.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping // when we'll insert a new resource in the HTTP, we use this annotation, instead of "@GetMapping"
	//use @RequestBody to show that this object will arrive as a JSon mode when do the request, and this JSon will be "deserialized" to a User object   
	public ResponseEntity<User> insert(@RequestBody User obj){
		obj = userService.insertUser(obj);

		/*The type of object expected in the created method is "URI", because, in the HTTP standard, this method needs the 
		 * response has a header called "location" containing the address of the new resource you inserted.
		 * 
		 * To generate this object, is necessary the following command:
		 * What we need to know is that this "path("/{id}")" is referring to the new object Id that 
		 * will be added, and this id must be passed inside the parameter of the "buildAndExpand()" method 
		 * */
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		userService.deleteUser(id);
		return ResponseEntity.noContent().build();	// noContent is the method we use when there isn't return
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
		obj = userService.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
}
