package com.exam.giorgibazierashvili.servicesImpl;

import com.exam.giorgibazierashvili.constants.RecordState;
import com.exam.giorgibazierashvili.dtos.RoomDTO;
import com.exam.giorgibazierashvili.entities.RoomEntity;
import com.exam.giorgibazierashvili.repositories.HotelRepository;
import com.exam.giorgibazierashvili.repositories.RoomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class RoomServices {
    @Autowired
    private RoomsRepository roomsRepository;
    @Autowired
    private HotelRepository hotelRepository;

    public RoomDTO addRoom(RoomDTO roomDTO) {
        RoomEntity room = new RoomEntity();
        room.setRecordState(RecordState.ACTIVE);
        room.setPricePerDay(roomDTO.getPricePerDay());
        room.setHotel( hotelRepository.findById(roomDTO.getHotelId()).orElse(null));
        if (room.getHotel() == null) {
            throw new EmptyResultDataAccessException("HOTEL NOT FOUND: " + roomDTO.getHotelId(), 404);
        }
        roomsRepository.saveAndFlush(room);
        return new RoomDTO(room.getHotel().getId(),room.getId(),room.getPricePerDay());
    }

    public RoomDTO getRoomById(Long roomId) {
        RoomEntity room = roomsRepository.findById(roomId).orElse(null);
        if (room == null) {
            throw new EmptyResultDataAccessException("ROOM NOT FOUND ", 404);
        } else {
            return new RoomDTO(room.getId(), room.getHotel().getId(), room.getPricePerDay());
        }
    }
}
