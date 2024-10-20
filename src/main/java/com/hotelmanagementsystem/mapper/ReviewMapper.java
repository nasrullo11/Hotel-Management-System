package com.hotelmanagementsystem.mapper;

import com.hotelmanagementsystem.dto.ReviewRequestDTO;
import com.hotelmanagementsystem.dto.ReviewResponseDTO;
import com.hotelmanagementsystem.model.Review;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    ReviewRequestDTO toReviewDTO(Review review);

    Review toReview(ReviewRequestDTO reviewRequestDTO);
    ReviewResponseDTO toReviewResponseDTO(Review review);
}
