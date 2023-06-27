package com.exam.giorgibazierashvili.servicesImpl;

import com.exam.giorgibazierashvili.constants.RecordState;
import com.exam.giorgibazierashvili.dtos.HotelDTO;
import com.exam.giorgibazierashvili.entities.HotelEntity;
import com.exam.giorgibazierashvili.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServices {
    @Autowired
    private HotelRepository hotelRepository;

    public HotelDTO addHotel(HotelDTO hotelDTO) {
        HotelEntity hotel = new HotelEntity();
        hotel.setHotelName(hotelDTO.getName());
        hotel.setRecordState(RecordState.INACTIVE);
        hotelRepository.saveAndFlush(hotel);
        return new HotelDTO(hotel.getId(), hotel.getHotelName());
    }

    public void deleteHotel(HotelEntity hotel) {
        hotelRepository.delete(hotel);
    }

    public List<HotelEntity> getAllHotels(HotelEntity hotel) {
        return hotelRepository.findAll();
    }

    public HotelDTO findHotelById(Long id) {
        HotelEntity hotel = hotelRepository.findById(id).orElse(null);
        if (hotel == null) {
            throw new EmptyResultDataAccessException(id + " -> hotel : not found", 404);
        } else {
            return new HotelDTO(hotel.getId(),hotel.getHotelName());
        }
    }

}
