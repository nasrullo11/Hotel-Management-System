package com.hotelmanagementsystem.dto;

import lombok.Data;

@Data
public class PaymentRequestDTO {
    private Double amount;
    private String paymentMethod;
}
