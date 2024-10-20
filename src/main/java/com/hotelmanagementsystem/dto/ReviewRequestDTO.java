package com.hotelmanagementsystem.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewRequestDTO {
    private Long hotelId;
    private Long guestId;
    private Integer rating;
    private String comment;
    private LocalDate reviewDate;
}
