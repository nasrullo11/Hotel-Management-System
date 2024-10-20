package com.hotelmanagementsystem.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class PaymentResponseDTO {
    private Long paymentId;
    private Long bookingId;
    private Double amount;
    private LocalDate paymentDate;
    private String paymentMethod;
    private String status;
}
