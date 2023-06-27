package com.exam.giorgibazierashvili.repositories;

import com.exam.giorgibazierashvili.entities.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface BookingRepository extends JpaRepository<BookingEntity, Long> {
@Query(value = "SELECT * FROM `bookings` WHERE room_id = ?1", nativeQuery = true)
ArrayList<BookingEntity> getAllBookingsByRoomId(Long roomId);
}
