package com.microservice.user.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice.user.service.entities.Hotel;

@FeignClient(name="HOTEL-SERVICE")
public interface HotelService {


    //get single
    @GetMapping("/hotels/{ID}")
    Hotel getHotel(@PathVariable("ID") String hotelId);

}
