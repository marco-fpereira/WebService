package com.example.WebService.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.WebService.entities.Order;
import com.example.WebService.entities.User;
import com.example.WebService.repositories.OrderRepository;
import com.example.WebService.repositories.UserRepository;

@Configuration	//identifying that this class is a specific class for configuration 
@Profile("test") //identifying that this configuration is specific to the test profile
public class TestConfig implements CommandLineRunner {
	
	@Autowired	// this annotation will solve the dependency injection and associate a UserRepository instance to this class
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		// this method that belongs to the "CommandLineRunner" interface, does what is here to be executed when the program is started
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1); 
		
		//saving users and orders in the database
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
	}

}
