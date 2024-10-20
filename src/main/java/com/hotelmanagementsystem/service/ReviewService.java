package com.hotelmanagementsystem.service;

import com.hotelmanagementsystem.dto.ReviewRequestDTO;
import com.hotelmanagementsystem.dto.ReviewResponseDTO;
import com.hotelmanagementsystem.mapper.ReviewMapper;
import com.hotelmanagementsystem.model.Review;
import com.hotelmanagementsystem.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ReviewMapper reviewMapper;

    public ReviewResponseDTO createReview(ReviewRequestDTO reviewRequestDTO) {
        Review review = reviewMapper.toReview(reviewRequestDTO);
        Review savedReview = reviewRepository.save(review);
        return reviewMapper.toReviewResponseDTO(savedReview);
    }

    public ReviewResponseDTO getReviewById(Long id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found with id " + id));
        return reviewMapper.toReviewResponseDTO(review);
    }

    public List<ReviewResponseDTO> getAllReviews() {
        List<Review> reviews = reviewRepository.findAll();
        return reviews.stream()
                .map(reviewMapper::toReviewResponseDTO)
                .collect(Collectors.toList());
    }

    public ReviewResponseDTO updateReview(Long id, ReviewRequestDTO reviewRequestDTO) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found with id " + id));

        review.setRating(reviewRequestDTO.getRating());
        review.setComment(reviewRequestDTO.getComment());

        Review updatedReview = reviewRepository.save(review);
        return reviewMapper.toReviewResponseDTO(updatedReview);
    }

    public void deleteReview(Long id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found with id " + id));
        reviewRepository.delete(review);
    }
}
