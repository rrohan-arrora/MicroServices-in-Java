package com.hotel.service.HotelService.services.implemetation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.service.HotelService.entities.Hotel;
import com.hotel.service.HotelService.repositories.HotelRepository;
import com.hotel.service.HotelService.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	private HotelRepository hotelRepo;

	@Override
	public Hotel create(Hotel hotel) {
		// TODO Auto-generated method stub
		return hotelRepo.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotels() {
		// TODO Auto-generated method stub
		return hotelRepo.findAll();
	}

	@Override
	public Optional<Hotel> getSingleHotel(String hotelId) {
		// TODO Auto-generated method stub
		return hotelRepo.findById(hotelId);
	}

}
