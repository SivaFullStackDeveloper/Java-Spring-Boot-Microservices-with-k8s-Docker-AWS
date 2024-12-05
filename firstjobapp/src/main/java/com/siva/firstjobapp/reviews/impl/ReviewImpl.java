package com.siva.firstjobapp.reviews.impl;

import com.siva.firstjobapp.reviews.model.Review;
import com.siva.firstjobapp.reviews.repo.ReviewRepo;
import com.siva.firstjobapp.reviews.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewImpl implements ReviewService {
    ReviewRepo reviewRepo;

    public ReviewImpl(ReviewRepo reviewRepo) {
        this.reviewRepo = reviewRepo;
    }

    @Override
    public List<Review> findAll() {
        return reviewRepo.findAll();
    }

    @Override
    public void createJob(Review review) {
        reviewRepo.save(review);
    }

    @Override
    public Optional<Review> getJobById(Long id) {
        Optional<Review> review = reviewRepo.findById(id);

                return review;
    }

    @Override
    public boolean deleteById(Long id) {
       reviewRepo.deleteById(id);

        return  true;
    }

    @Override
    public Optional<Review> updateById(Review review, Long id) {
        Optional<Review> review1 = reviewRepo.findById(id);

            if (review1.get().getId()==id){
                review1.get().setDescription(review.getDescription());
                review1.get().setTitle(review.getTitle());

                reviewRepo.save(review1.get());
            }

        return review1;
    }
}
