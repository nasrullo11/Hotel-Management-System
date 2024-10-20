package com.hotelmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GuestResponseDTO {
    private Long guestId;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String address;
}
