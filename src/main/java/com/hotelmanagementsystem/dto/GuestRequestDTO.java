package com.hotelmanagementsystem.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GuestRequestDTO {
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String address;
}
