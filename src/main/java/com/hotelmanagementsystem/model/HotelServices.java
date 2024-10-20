package com.hotelmanagementsystem.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class HotelServices {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long serviceId;

    private String serviceType;
    private String description;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "hotelId")
    private Hotel hotel;

}

