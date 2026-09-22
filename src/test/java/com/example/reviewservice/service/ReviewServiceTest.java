package com.example.reviewservice.service;

import com.example.reviewservice.model.ReviewCollectionDTO;
import com.example.reviewservice.model.ReviewRequestDTO;
import com.example.reviewservice.repository.ReviewRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ReviewServiceTest {

    @Mock
    private ReviewRepository reviewRepository;

    @InjectMocks
    private ReviewService reviewService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void reviewRequestIsValid_ReturnsFalse_WhenRatingTooHigh() {
        ReviewRequestDTO request = new ReviewRequestDTO();
        request.setCustomerId(1L);
        request.setRoomId(101L);
        request.setStartDate(LocalDate.now());
        request.setEndDate(LocalDate.now().plusDays(2));
        request.setRating(6);
        request.setComment("Great room");

        boolean isValid = reviewService.reviewRequestIsValid(request);

        assertFalse(isValid);
    }

    @Test
    void getReviewsForRoom_ReturnsEmptyCollection_WhenNoReviewsFound() {
        when(reviewRepository.findByRoomId(101L)).thenReturn(Collections.emptyList());

        ReviewCollectionDTO result = reviewService.getReviewsForRoom(101L);

        assertNotNull(result);
        assertEquals(0, result.getTotalReviews());
        assertEquals(0.0, result.getAverage());
        assertTrue(result.getReviews().isEmpty());
    }
}
