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
        Optional<Review> job = reviewRepo.findById(id);

                return job;
    }

    @Override
    public boolean deleteById(Long id) {
       reviewRepo.deleteById(id);

        return  true;
    }

    @Override
    public Optional<Review> updateById(Review review, Long id) {
        Optional<Review> job1 = reviewRepo.findById(id);

            if (job1.get().getId()==id){
                job1.get().setLocation(review.getLocation());
                job1.get().setDescription(review.getDescription());
                job1.get().setTitle(review.getTitle());
                job1.get().setMaxSalary(review.getMaxSalary());
                job1.get().setMinSalary(review.getMinSalary());
                reviewRepo.save(job1.get());
            }

        return job1;
    }
}
