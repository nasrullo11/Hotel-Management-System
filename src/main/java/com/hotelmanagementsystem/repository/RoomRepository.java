package com.hotelmanagementsystem.repository;

import com.hotelmanagementsystem.model.Hotel;
import com.hotelmanagementsystem.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    Hotel findByHotel_HotelId(Long hotelId);
}

