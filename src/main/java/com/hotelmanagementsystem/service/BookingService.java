package com.hotelmanagementsystem.service;

import com.hotelmanagementsystem.dto.BookingRequestDTO;
import com.hotelmanagementsystem.dto.BookingResponseDTO;
import com.hotelmanagementsystem.dto.PaymentRequestDTO;
import com.hotelmanagementsystem.mapper.BookingMapper;
import com.hotelmanagementsystem.model.Booking;
import com.hotelmanagementsystem.model.Guest;
import com.hotelmanagementsystem.model.Payment;
import com.hotelmanagementsystem.model.Room;
import com.hotelmanagementsystem.repository.BookingRepository;
import com.hotelmanagementsystem.repository.GuestRepository;
import com.hotelmanagementsystem.repository.PaymentRepository;
import com.hotelmanagementsystem.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final GuestRepository guestRepository;
    private final RoomRepository roomRepository;
    private final PaymentRepository paymentRepository;

    public BookingResponseDTO createBooking(BookingRequestDTO requestDTO, PaymentRequestDTO paymentRequestDTO) {
        Room room = roomRepository.findById(requestDTO.getRoomId())
                .orElseThrow(() -> new RuntimeException("Room not found with id " + requestDTO.getRoomId()));

        if (!"Available".equalsIgnoreCase(room.getStatus())) {
            throw new RuntimeException("Room is not available for booking.");
        }

        Guest guest = guestRepository.findById(requestDTO.getGuestId())
                .orElseThrow(() -> new RuntimeException("Guest not found with id " + requestDTO.getGuestId()));

        long daysStayed = ChronoUnit.DAYS.between(requestDTO.getCheckInDate(), requestDTO.getCheckOutDate());
        double totalPrice = room.getPrice() * daysStayed;

        Booking booking = new Booking();
        booking.setRoom(room);
        booking.setGuest(guest);
        booking.setCheckInDate(requestDTO.getCheckInDate());
        booking.setCheckOutDate(requestDTO.getCheckOutDate());
        booking.setNumberOfGuests(requestDTO.getNumberOfGuests());
        booking.setTotalPrice(totalPrice);
        booking.setStatus("Confirmed");

        Payment payment = new Payment();
        payment.setAmount(paymentRequestDTO.getAmount());
        payment.setPaymentMethod(paymentRequestDTO.getPaymentMethod());
        payment.setPaymentDate(LocalDate.now());
        payment.setStatus("Paid");

        payment.setBooking(booking);
        bookingRepository.save(booking);
        paymentRepository.save(payment);

        room.setStatus("Booked");
        roomRepository.save(room);

        return BookingMapper.convertToResponseDTO(booking);
    }

    public List<BookingResponseDTO> getAllBookings() {
        return bookingRepository.findAll().stream()
                .map(BookingMapper::convertToResponseDTO)
                .toList();
    }

    public BookingResponseDTO getBookingById(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found with id " + id));
        return BookingMapper.convertToResponseDTO(booking);
    }

    public BookingResponseDTO updateBooking(Long id, BookingRequestDTO requestDTO) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found with id " + id));

        Room room = roomRepository.findById(requestDTO.getRoomId())
                .orElseThrow(() -> new RuntimeException("Room not found with id " + requestDTO.getRoomId()));

        booking.setRoom(room);
        booking.setCheckInDate(requestDTO.getCheckInDate());
        booking.setCheckOutDate(requestDTO.getCheckOutDate());
        booking.setNumberOfGuests(requestDTO.getNumberOfGuests());
        booking.setTotalPrice(room.getPrice() * ChronoUnit.DAYS.between(requestDTO.getCheckInDate(), requestDTO.getCheckOutDate()));

        bookingRepository.save(booking);
        return BookingMapper.convertToResponseDTO(booking);
    }

    public void deleteBooking(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found with id " + id));

        Room room = booking.getRoom();
        room.setStatus("Available");
        roomRepository.save(room);

        bookingRepository.delete(booking);
    }
}
