package com.hotelmanagementsystem.mapper;

import com.hotelmanagementsystem.dto.BookingResponseDTO;
import com.hotelmanagementsystem.model.Booking;
import lombok.experimental.UtilityClass;

@UtilityClass
public class BookingMapper {
    public BookingResponseDTO convertToResponseDTO(Booking booking) {
        return BookingResponseDTO.builder()
                .bookingId(booking.getBookingId())
                .roomId(booking.getRoom().getRoomId())
                .roomNumber(booking.getRoom().getRoomNumber())
                .roomType(booking.getRoom().getRoomType())
                .status(booking.getRoom().getStatus())
                .guestName(booking.getGuest().getFirstName() + " " + booking.getGuest().getLastName())
                .checkInDate(booking.getCheckInDate())
                .checkOutDate(booking.getCheckOutDate())
                .numberOfGuests(booking.getNumberOfGuests())
                .totalPrice(booking.getTotalPrice())
                .build();
    }
}
