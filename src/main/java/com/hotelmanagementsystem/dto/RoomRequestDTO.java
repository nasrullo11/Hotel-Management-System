package com.hotelmanagementsystem.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomRequestDTO {
    private Long hotelId;
    private String roomNumber;
    private String roomType;
    private Double price;
    private String status;
}
