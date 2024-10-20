package com.hotelmanagementsystem.repository;

import com.hotelmanagementsystem.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByGuest_GuestId(Long guestId);
    List<Booking> findByRoom_RoomId(Long roomId);
}

