package com.hotelmanagementsystem.service;

import com.hotelmanagementsystem.dto.HotelRequestDTO;
import com.hotelmanagementsystem.dto.HotelResponseDTO;
import com.hotelmanagementsystem.mapper.HotelMapper;
import com.hotelmanagementsystem.model.Hotel;
import com.hotelmanagementsystem.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private HotelMapper hotelMapper;

    public HotelResponseDTO createHotel(HotelRequestDTO hotelRequestDTO) {
        Hotel hotel = hotelMapper.toHotel(hotelRequestDTO);
        Hotel savedHotel = hotelRepository.save(hotel);
        return hotelMapper.toHotelResponseDTO(savedHotel);
    }

    public HotelResponseDTO getHotelById(Long id) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hotel not found with id " + id));
        return hotelMapper.toHotelResponseDTO(hotel);
    }

    public List<HotelResponseDTO> getAllHotels() {
        List<Hotel> hotels = hotelRepository.findAll();
        return hotels.stream()
                .map(hotelMapper::toHotelResponseDTO)
                .collect(Collectors.toList());
    }

    public HotelResponseDTO updateHotel(Long id, HotelRequestDTO hotelRequestDTO) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hotel not found with id " + id));

        hotel.setName(hotelRequestDTO.getName());
        hotel.setAddress(hotelRequestDTO.getAddress());
        hotel.setPhone(hotelRequestDTO.getPhone());
        hotel.setEmail(hotelRequestDTO.getEmail());
        hotel.setRating(hotelRequestDTO.getRating());

        Hotel updatedHotel = hotelRepository.save(hotel);
        return hotelMapper.toHotelResponseDTO(updatedHotel);
    }

    public void deleteHotel(Long id) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hotel not found with id " + id));
        hotelRepository.delete(hotel);
    }
}
