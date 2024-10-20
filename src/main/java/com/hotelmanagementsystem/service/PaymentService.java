package com.hotelmanagementsystem.service;

import com.hotelmanagementsystem.dto.PaymentRequestDTO;
import com.hotelmanagementsystem.dto.PaymentResponseDTO;
import com.hotelmanagementsystem.mapper.PaymentMapper;
import com.hotelmanagementsystem.model.Booking;
import com.hotelmanagementsystem.model.Payment;
import com.hotelmanagementsystem.repository.BookingRepository;
import com.hotelmanagementsystem.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final BookingRepository bookingRepository;

    public PaymentResponseDTO createPayment(Long bookingId, PaymentRequestDTO paymentRequestDTO) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found with id " + bookingId));

        Payment payment = new Payment();
        payment.setBooking(booking);
        payment.setAmount(paymentRequestDTO.getAmount());
        payment.setPaymentMethod(paymentRequestDTO.getPaymentMethod());
        payment.setPaymentDate(LocalDate.now());
        payment.setStatus("SUCCESS");

        Payment savedPayment = paymentRepository.save(payment);
        return PaymentMapper.convertToResponseDTO(savedPayment);
    }

    public PaymentResponseDTO getPaymentByBookingId(Long bookingId) {
        Payment payment = paymentRepository.findByBooking_BookingId(bookingId)
                .orElseThrow(() -> new RuntimeException("Payment not found for booking id " + bookingId));
        return PaymentMapper.convertToResponseDTO(payment);
    }

    public PaymentResponseDTO updatePaymentStatus(Long paymentId, String status) {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment not found with id " + paymentId));

        payment.setStatus(status);
        Payment updatedPayment = paymentRepository.save(payment);
        return PaymentMapper.convertToResponseDTO(updatedPayment);
    }

    public void deletePayment(Long paymentId) {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment not found with id " + paymentId));

        paymentRepository.delete(payment);
    }
}
