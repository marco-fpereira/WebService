package com.example.WebService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.WebService.entities.User;

@Repository	//annotation needed to identify that this is a repository-type Spring component
public interface UserRepository extends JpaRepository<User, Long>{

	// this interface is already able to instantiate a "repository" object which has a lot of operations to work with the specified type 
	// obs: this interface has a standard implementation to the type "User", therefore, isn't necessary to do another implementation
	
}
