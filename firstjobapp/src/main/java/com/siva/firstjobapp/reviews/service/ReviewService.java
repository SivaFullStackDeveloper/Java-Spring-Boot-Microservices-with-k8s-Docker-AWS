package com.siva.firstjobapp.reviews.service;

import com.siva.firstjobapp.reviews.model.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    List<Review> findAll();
    void createJob(Review review);
    Optional<Review> getJobById(Long id);
    boolean deleteById(Long id);
    Optional<Review> updateById(Review review, Long id);
}
