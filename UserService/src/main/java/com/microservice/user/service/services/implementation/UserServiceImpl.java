package com.microservice.user.service.services.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.user.service.entities.User;
import com.microservice.user.service.repositories.UserRepository;
import com.microservice.user.service.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public Optional<User> getUser(String userId) {
		// TODO Auto-generated method stub
		return userRepo.findById(userId);//.orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on server !! : " + userId));
	}

}
