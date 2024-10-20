package com.hotelmanagementsystem.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookingRequestDTO {
    private Long guestId;
    private Long roomId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int numberOfGuests;
}
