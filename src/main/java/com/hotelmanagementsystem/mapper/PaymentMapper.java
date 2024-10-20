package com.hotelmanagementsystem.mapper;

import com.hotelmanagementsystem.dto.PaymentResponseDTO;
import com.hotelmanagementsystem.model.Payment;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PaymentMapper {
    public PaymentResponseDTO convertToResponseDTO(Payment payment) {
        return PaymentResponseDTO.builder()
                .paymentId(payment.getPaymentId())
                .bookingId(payment.getBooking().getBookingId())
                .amount(payment.getAmount())
                .paymentDate(payment.getPaymentDate())
                .paymentMethod(payment.getPaymentMethod())
                .status(payment.getStatus())
                .build();
    }
}
