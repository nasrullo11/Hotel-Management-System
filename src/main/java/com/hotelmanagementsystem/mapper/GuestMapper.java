package com.hotelmanagementsystem.mapper;

import com.hotelmanagementsystem.dto.GuestRequestDTO;
import com.hotelmanagementsystem.dto.GuestResponseDTO;
import com.hotelmanagementsystem.model.Guest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GuestMapper {

    GuestRequestDTO toGuestDTO(Guest guest);
    Guest toGuest(GuestRequestDTO guestRequestDTO);
    GuestResponseDTO toGuestResponseDTO(Guest guest);
}
