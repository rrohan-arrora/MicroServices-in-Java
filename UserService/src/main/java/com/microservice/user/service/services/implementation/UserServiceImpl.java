package com.microservice.user.service.services.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.microservice.user.service.entities.Hotel;
import com.microservice.user.service.entities.Rating;
import com.microservice.user.service.entities.User;
import com.microservice.user.service.feign.HotelService;
import com.microservice.user.service.repositories.UserRepository;
import com.microservice.user.service.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService;
	
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
		Rating[] userRatings = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(), Rating[].class);
//		logger.info("{} ", userRatings);
		
		List<Rating> ratings = Arrays.stream(userRatings).toList();
		
		for(Rating rate: ratings) {
			// api call to hotel service to get the hotel of the rating
//			ResponseEntity<Hotel> forEntity= restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rate.getHotelId(), Hotel.class);	
//			Hotel hotel = forEntity.getBody();
			
			Hotel hotel = hotelService.getHotel(rate.getHotelId());
			
//			logger.info("{} ", hotel.getId());
			
			hotel.setId(rate.getHotelId());
			
			rate.setHotel(hotel);
		}
		
		user.setRatings(ratings);
		
		
		return user;
	}

}
