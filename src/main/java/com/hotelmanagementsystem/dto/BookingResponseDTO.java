package com.hotelmanagementsystem.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class BookingResponseDTO {
    private Long bookingId;
    private Long roomId;
    private String roomNumber;
    private String roomType;
    private String status;
    private String guestName;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int numberOfGuests;
    private Double totalPrice;
}
