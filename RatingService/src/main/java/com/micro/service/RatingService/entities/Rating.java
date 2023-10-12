package com.micro.service.RatingService.entities;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("user_ratings")
public class Rating {
	
	@MongoId(value = FieldType.OBJECT_ID)
    private String ratingId;
   
    private String userId;
    
    private String hotelId;
    
    private  int rating;
    
    private  String feedback;
}
