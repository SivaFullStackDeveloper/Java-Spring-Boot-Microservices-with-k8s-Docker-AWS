package com.siva.reviewMs.reviews.impl;


import com.siva.reviewMs.reviews.model.Review;
import com.siva.reviewMs.reviews.repo.ReviewRepo;
import com.siva.reviewMs.reviews.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewImpl implements ReviewService {
    private ReviewRepo reviewRepo;
  //  private CompanyService companyService;

    public ReviewImpl(ReviewRepo reviewRepo
                     // CompanyService companyService
    ) {

        this.reviewRepo = reviewRepo;
        //this.companyService = companyService;
    }

    @Override
    public List<Review> findByCompanyId(Long companyId) {
        return reviewRepo.findByCompanyId(companyId);

    }

    @Override
    public Review getReview( Long reviewId) {
       Review review = reviewRepo.findById(reviewId).orElse(null);
       if(review!=null){
           return review;
       }

        return null;


    }

    @Override
    public Review updateReview( Long reviewId, Review updatedReview) {
        if (reviewId!=null){
            Review reviewinDb = reviewRepo.findById(reviewId).orElse(null);
            if (reviewinDb!=null){
                reviewinDb.setDescription(updatedReview.getDescription());
                reviewinDb.setRating(updatedReview.getRating());
                reviewinDb.setTitle(updatedReview.getTitle());
                reviewinDb.setCompanyId(updatedReview.getCompanyId());
                Review save = reviewRepo.save(reviewinDb);
                return save;
            }
        }


        return null;
    }

    @Override
    public void deleteReview( Long reviewId) {
        Review reviewinDb = reviewRepo.findById(reviewId).orElse(null);
       if(reviewinDb!=null){
           reviewRepo.delete(reviewinDb);
       }

    }

    @Override
    public void addReview(Review review, Long companyId) {

        if(companyId!=null && review != null){
            review.setCompanyId(companyId);
             reviewRepo.save(review);
        }
    }

}
