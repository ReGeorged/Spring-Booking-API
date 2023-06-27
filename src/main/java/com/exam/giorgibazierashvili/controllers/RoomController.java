package com.exam.giorgibazierashvili.controllers;

import com.exam.giorgibazierashvili.dtos.RoomDTO;
import com.exam.giorgibazierashvili.servicesImpl.RoomServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/room")
public class RoomController {
    @Autowired
    private RoomServices roomServices;

    @PostMapping("/add")
    public RoomDTO addRoom(@RequestBody RoomDTO roomDTO){
        return roomServices.addRoom(roomDTO);
    }
    @GetMapping("{id}")
    public RoomDTO getRoomById(@PathVariable Long id){
        return  roomServices.getRoomById(id);
    }
}
