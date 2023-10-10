package com.hotel.service.HotelService.services;

import java.util.List;
import java.util.Optional;

import com.hotel.service.HotelService.entities.Hotel;

public interface HotelService {
	
	// create a hotel
	Hotel create(Hotel hotel);
	
	// get all hotels
	List<Hotel> getAllHotels();
	
	// get single hotel
	Optional<Hotel> getSingleHotel(String hotelId);
}
