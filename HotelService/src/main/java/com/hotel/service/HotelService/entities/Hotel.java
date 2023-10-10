package com.hotel.service.HotelService.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="hotels")
@Data
public class Hotel {
	
	@Id
	@Column(name="ID")
	private String  hotelId;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="LOCATION")
	private String location;
	
	@Column(name="ABOUT")
	private String about;
}
