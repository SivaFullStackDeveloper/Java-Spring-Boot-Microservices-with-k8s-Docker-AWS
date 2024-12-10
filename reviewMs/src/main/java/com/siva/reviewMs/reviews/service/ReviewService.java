package com.siva.reviewMs.reviews.service;



import com.siva.reviewMs.reviews.model.Review;

import java.util.List;

public interface ReviewService {
    List<Review> findByCompanyId(Long companyId);
    Review getReview(Long reviewId);
    Review updateReview(Long reviewId,Review review);
    void deleteReview(Long reviewId);
    void addReview(Review review,Long companyId);

}
