package com.exam.giorgibazierashvili.controllers;

import com.exam.giorgibazierashvili.dtos.HotelDTO;
import com.exam.giorgibazierashvili.servicesImpl.HotelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private HotelServices hotelServices;

    @GetMapping("{id}")
    private ResponseEntity getHotelById(@PathVariable Long id) {
        HotelDTO hotel = hotelServices.findHotelById(id);
        return ResponseEntity.ok(hotel);
    }
    @PostMapping("/add")
    public ResponseEntity addHotel(@RequestBody HotelDTO hotelDTO) {
        HotelDTO hotel = hotelServices.addHotel(hotelDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotel);
    }
}
