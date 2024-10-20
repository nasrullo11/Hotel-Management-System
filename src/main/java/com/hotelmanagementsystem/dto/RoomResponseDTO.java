package com.hotelmanagementsystem.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoomResponseDTO {
    private int roomId;
    private Long hotelId;
    private String roomNumber;
    private String roomType;
    private Double price;
    private String status;
}
