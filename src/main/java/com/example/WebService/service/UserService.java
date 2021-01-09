package com.example.WebService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.WebService.entities.User;
import com.example.WebService.repositories.UserRepository;

/* The "component" annotation is used to identify that this class is a component of Spring, it's necessary
 * because this needs to be registered in the dependency injection mechanism so that, together with 
 * the "autowired" annotation from resource layer, make the mechanism work correctly.
	@Component
*/

@Service	// however, "service" is an more specific annotation to this type of component (service layer), so its use is the most desirable
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAllUsers(){
		return userRepository.findAll();
	}
	
	public User findById(Long id) {
		return userRepository.findById(id).get();
	}
}
