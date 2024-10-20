package com.hotelmanagementsystem.controller;

import com.hotelmanagementsystem.dto.BookingRequestDTO;
import com.hotelmanagementsystem.dto.BookingResponseDTO;
import com.hotelmanagementsystem.dto.PaymentRequestDTO;
import com.hotelmanagementsystem.service.BookingService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
@Tag(name = "Booking")
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity<BookingResponseDTO> createBooking(@RequestBody BookingRequestDTO requestDTO,
                                                            @RequestBody PaymentRequestDTO paymentRequestDTO) {
        BookingResponseDTO bookingResponseDTO = bookingService.createBooking(requestDTO, paymentRequestDTO);
        return ResponseEntity.ok(bookingResponseDTO);
    }

    @GetMapping
    public ResponseEntity<List<BookingResponseDTO>> getAllBookings() {
        List<BookingResponseDTO> bookings = bookingService.getAllBookings();
        return ResponseEntity.ok(bookings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingResponseDTO> getBookingById(@PathVariable Long id) {
        BookingResponseDTO bookingResponseDTO = bookingService.getBookingById(id);
        return ResponseEntity.ok(bookingResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookingResponseDTO> updateBooking(@PathVariable Long id, @RequestBody BookingRequestDTO requestDTO) {
        BookingResponseDTO bookingResponseDTO = bookingService.updateBooking(id, requestDTO);
        return ResponseEntity.ok(bookingResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }
}
