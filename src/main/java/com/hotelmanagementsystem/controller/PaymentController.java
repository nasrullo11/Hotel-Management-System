package com.hotelmanagementsystem.controller;

import com.hotelmanagementsystem.dto.PaymentRequestDTO;
import com.hotelmanagementsystem.dto.PaymentResponseDTO;
import com.hotelmanagementsystem.service.PaymentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
@Tag(name = "Payment")
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/{bookingId}")
    public ResponseEntity<PaymentResponseDTO> createPayment(
            @PathVariable Long bookingId,
            @RequestBody PaymentRequestDTO paymentRequestDTO) {
        PaymentResponseDTO paymentResponse = paymentService.createPayment(bookingId, paymentRequestDTO);
        return ResponseEntity.ok(paymentResponse);
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<PaymentResponseDTO> getPaymentByBookingId(@PathVariable Long bookingId) {
        PaymentResponseDTO paymentResponse = paymentService.getPaymentByBookingId(bookingId);
        return ResponseEntity.ok(paymentResponse);
    }

    @PatchMapping("/{paymentId}/status")
    public ResponseEntity<PaymentResponseDTO> updatePaymentStatus(
            @PathVariable Long paymentId,
            @RequestParam String status) {
        PaymentResponseDTO updatedPayment = paymentService.updatePaymentStatus(paymentId, status);
        return ResponseEntity.ok(updatedPayment);
    }

    @DeleteMapping("/{paymentId}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long paymentId) {
        paymentService.deletePayment(paymentId);
        return ResponseEntity.noContent().build();
    }
}
