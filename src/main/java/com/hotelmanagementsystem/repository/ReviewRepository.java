package com.hotelmanagementsystem.repository;

import com.hotelmanagementsystem.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByHotel_HotelId(Long hotelId);
    List<Review> findByGuest_GuestId(Long guestId);
}

