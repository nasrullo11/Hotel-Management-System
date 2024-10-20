package com.hotelmanagementsystem.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long hotelId;

    private String name;
    private String address;
    private String phone;
    private String email;
    private int rating;

    @OneToMany(mappedBy = "hotel")
    private List<Room> rooms;

    @OneToMany(mappedBy = "hotel")
    private List<HotelServices> hotelServices;

    @OneToMany(mappedBy = "hotel")
    private List<Review> reviews;
}

