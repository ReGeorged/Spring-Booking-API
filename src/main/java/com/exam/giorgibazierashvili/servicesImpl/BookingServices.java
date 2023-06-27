package com.exam.giorgibazierashvili.servicesImpl;

import com.exam.giorgibazierashvili.dtos.BookingDTO;
import com.exam.giorgibazierashvili.entities.BookingEntity;
import com.exam.giorgibazierashvili.repositories.BookingRepository;
import com.exam.giorgibazierashvili.repositories.RoomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BookingServices {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private RoomsRepository roomsRepository;


    public BookingDTO addBooking(BookingDTO bookingDTO) {
        BookingEntity bookingEntity = new BookingEntity();
        bookingEntity.setRoom(roomsRepository.findById(bookingDTO.getRoomId()).orElse(null));
        bookingEntity.setStartDate(bookingDTO.getStartDate());
        bookingEntity.setEndDate(bookingDTO.getEndDate());
        bookingEntity.setUser(bookingDTO.getUser());
        if (bookingEntity.getRoom() == null) {
            throw new EmptyResultDataAccessException("ROOM NOT FOUND", 404);
        } else {
            if (isBooked(bookingDTO)) {
                throw new EmptyResultDataAccessException("room is booked", 404);
            } else {
                bookingRepository.save(bookingEntity);
                return new BookingDTO(
                        bookingEntity.getRoom().getId(),
                        bookingEntity.getStartDate(),
                        bookingEntity.getEndDate(),
                        bookingEntity.getUser());
            }
        }
    }

    public BookingDTO getBooking(Long id) {
        BookingEntity booking = bookingRepository.findById(id).orElse(null);
        if (booking == null) {
            throw new EmptyResultDataAccessException("booking not found", 404);
        } else {
            return new BookingDTO(booking.getRoom().getId(), booking.getStartDate(), booking.getEndDate(), booking.getUser());
        }
    }

    public boolean isBooked(BookingDTO bookingDTO) {
        ArrayList<BookingDTO> allBookingsForThisRoom = getAllBookingsForRoom(bookingDTO.getRoomId());
        if (allBookingsForThisRoom == null || allBookingsForThisRoom.isEmpty()) {
            return false;
        } else {
            boolean booked = true;
            for (BookingDTO bookingDtos : allBookingsForThisRoom) {
                if (bookingDTO.getStartDate().after(bookingDtos.getEndDate()) && bookingDTO.getEndDate().before(bookingDtos.getStartDate())) {
                    booked = false;
                    break;
                }
            }
            return  booked;
        }
    }

    public ArrayList<BookingDTO> getAllBookingsForRoom(Long roomId) {
        ArrayList<BookingEntity> bookingEntityList = bookingRepository.getAllBookingsByRoomId(roomId);
        ArrayList<BookingDTO> bookingDTOS = new ArrayList<>();
        for (BookingEntity booking : bookingEntityList) {
            BookingDTO bookingDTO = new BookingDTO(booking.getRoom().getId(), booking.getStartDate(), booking.getEndDate(), booking.getUser());
            bookingDTOS.add(bookingDTO);
        }
        return bookingDTOS;
    }

}
