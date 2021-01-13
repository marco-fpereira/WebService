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
	
	public User insertUser(User user) {
		return userRepository.save(user);
	}
	
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
	
	public User update (Long id, User obj) {
		/*this method instantiate a User, but it doesn't make changes in the database yet, it only keeps 
		 * the object monitored by JPA. So I can work with it and later carry out some operation with database*/
		User entity = userRepository.getOne(id);
		updateData(entity, obj);
		return userRepository.save(entity);
		
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
