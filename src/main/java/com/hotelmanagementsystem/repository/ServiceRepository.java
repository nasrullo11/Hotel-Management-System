package com.hotelmanagementsystem.repository;

import com.hotelmanagementsystem.model.HotelServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<HotelServices, Long> {
    List<HotelServices> findByHotel_HotelId(Long hotelId);
}

