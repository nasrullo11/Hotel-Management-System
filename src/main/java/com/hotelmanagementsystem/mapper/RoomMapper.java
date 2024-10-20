package com.hotelmanagementsystem.mapper;

import com.hotelmanagementsystem.dto.RoomResponseDTO;
import com.hotelmanagementsystem.model.Room;
import lombok.experimental.UtilityClass;

@UtilityClass
public class RoomMapper {
    public RoomResponseDTO convertToResponseDTO(Room room) {
        Long hotelId = room.getHotel() != null ? room.getHotel().getHotelId() : null;
        return RoomResponseDTO.builder()
                .roomId(Math.toIntExact(room.getRoomId()))
                .hotelId(hotelId)
                .roomNumber(room.getRoomNumber())
                .roomType(room.getRoomType())
                .price(room.getPrice())
                .status(room.getStatus())
                .build();
    };

    private String checkToNull(String string){
        return string != null ? string : "";
    }
}
