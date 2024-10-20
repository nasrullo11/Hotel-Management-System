package com.hotelmanagementsystem.mapper;

import com.hotelmanagementsystem.dto.HotelRequestDTO;
import com.hotelmanagementsystem.dto.HotelResponseDTO;
import com.hotelmanagementsystem.model.Hotel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HotelMapper {

    HotelRequestDTO toHotelDTO(Hotel hotel);
    Hotel toHotel(HotelRequestDTO hotelRequestDTO);
    HotelResponseDTO toHotelResponseDTO(Hotel hotel);
}
