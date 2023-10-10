package com.microservice.user.service.services;

import java.util.List;
import java.util.Optional;

import com.microservice.user.service.entities.User;

public interface UserService {
	
	// create User
	User saveUser(User user);
	
	// get all users
	List<User> getAllUsers();
	
	//get single User
	Optional<User> getUser(String userId);
	

}
