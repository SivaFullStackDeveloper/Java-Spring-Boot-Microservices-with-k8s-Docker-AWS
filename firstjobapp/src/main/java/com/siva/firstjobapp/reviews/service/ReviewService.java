package com.siva.firstjobapp.reviews.service;

import com.siva.firstjobapp.reviews.model.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    List<Review> findByCompanyId(Long companyId);
    Review getReview(Long companyId,Long reviewId);
    Review updateReview(Long companyId,Long reviewId,Review review);
    void deleteReview(Long companyId,Long reviewId);
    void addReview(Review review,Long companyId);

}
