package com.hotelmanagementsystem.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HotelRequestDTO {
    private String name;
    private String address;
    private String phone;
    private String email;
    private int rating;
}
