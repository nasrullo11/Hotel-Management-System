package com.hotelmanagementsystem.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long paymentId;

    @OneToOne
    @JoinColumn(name = "bookingId")
    private Booking booking;

    private Double amount;
    private LocalDate paymentDate;
    private String paymentMethod;
    private String status;
}

