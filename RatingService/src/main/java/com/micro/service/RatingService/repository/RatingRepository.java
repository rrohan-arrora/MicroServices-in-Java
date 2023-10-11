package com.micro.service.RatingService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.micro.service.RatingService.entities.Rating;

public interface RatingRepository extends MongoRepository<Rating, String> {
	
}
