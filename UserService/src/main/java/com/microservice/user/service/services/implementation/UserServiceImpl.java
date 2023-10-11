package com.microservice.user.service.services.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.microservice.user.service.entities.Rating;
import com.microservice.user.service.entities.User;
import com.microservice.user.service.repositories.UserRepository;
import com.microservice.user.service.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		String id = UUID.randomUUID().toString();
		user.setUserId(id);
		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public User getUser(String userId) {
		// TODO Auto-generated method stub
		User user =  userRepo.findById(userId).orElseThrow();
		
		// fetch ratings of the above user from RATING SERVICE
		ArrayList<Rating> userRatings = restTemplate.getForObject("http://localhost:8083/ratings/users/"+user.getUserId(), ArrayList.class);
		logger.info("{} ", userRatings);
		
		user.setRatings(userRatings);
		
		
		return user;
	}

}
