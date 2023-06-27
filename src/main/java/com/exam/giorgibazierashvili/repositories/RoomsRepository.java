package com.exam.giorgibazierashvili.repositories;

import com.exam.giorgibazierashvili.entities.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomsRepository extends JpaRepository<RoomEntity, Long> {
}
