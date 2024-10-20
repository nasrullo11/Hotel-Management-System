package com.hotelmanagementsystem.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookingId;

    @ManyToOne
    @JoinColumn(name = "guestId")
    private Guest guest;

    @ManyToOne
    @JoinColumn(name = "roomId")
    private Room room;

    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int numberOfGuests;
    private Double totalPrice;
    private String status;

    @OneToOne(mappedBy = "booking")
    private Payment payment;
}

