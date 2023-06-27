package com.exam.giorgibazierashvili.controllers;

import com.exam.giorgibazierashvili.dtos.BookingDTO;
import com.exam.giorgibazierashvili.servicesImpl.BookingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private BookingServices bookingServices;
    @PostMapping
    public BookingDTO addBooking(@RequestBody  BookingDTO bookingDTO){
        return  bookingServices.addBooking(bookingDTO);
    }

    @GetMapping("/list/{roomId}")
    public ArrayList<BookingDTO> getAllBookingsForRoomById(@PathVariable Long roomId){
        return  bookingServices.getAllBookingsForRoom(roomId);
    }
}
