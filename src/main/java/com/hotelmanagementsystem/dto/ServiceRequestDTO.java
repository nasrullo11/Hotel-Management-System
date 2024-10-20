package com.hotelmanagementsystem.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceRequestDTO {
    private String serviceType;
    private String description;
    private Double price;
}
