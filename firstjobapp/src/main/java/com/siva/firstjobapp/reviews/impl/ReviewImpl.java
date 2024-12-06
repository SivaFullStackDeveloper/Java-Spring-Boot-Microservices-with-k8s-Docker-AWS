package com.siva.firstjobapp.reviews.impl;

import com.siva.firstjobapp.company.model.Company;
import com.siva.firstjobapp.company.service.CompanyService;
import com.siva.firstjobapp.reviews.model.Review;
import com.siva.firstjobapp.reviews.repo.ReviewRepo;
import com.siva.firstjobapp.reviews.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewImpl implements ReviewService {
    private  ReviewRepo reviewRepo;
    private CompanyService companyService;

    public ReviewImpl(ReviewRepo reviewRepo, CompanyService companyService) {

        this.reviewRepo = reviewRepo;
        this.companyService = companyService;
    }

    @Override
    public List<Review> findByCompanyId(Long companyId) {
        return reviewRepo.findByCompanyId(companyId);
    }

    @Override
    public Review getReview(Long companyId, Long reviewId) {
        List<Review> review = reviewRepo.findByCompanyId(companyId);
        for(Review review1:review){
            if(review1.getId() == reviewId){
                return review1;
            }
        }
        return null;


    }

    @Override
    public Review updateReview(Long companyId, Long reviewId, Review review) {
        List<Review> reviewinDb = reviewRepo.findByCompanyId(companyId);
        for(Review review2:reviewinDb){
            if(review2.getId() == reviewId){
                review2.setDescription(review.getDescription());
                review2.setRating(review.getRating());
                review2.setTitle(review.getTitle());
                Review save = reviewRepo.save(review2);
                return save;
            }
        }
        return null;
    }

    @Override
    public void deleteReview(Long companyId, Long reviewId) {
        List<Review> reviewinDb = reviewRepo.findByCompanyId(companyId);
        for(Review review2:reviewinDb){
            reviewRepo.deleteById(review2.getId());
        }
    }

    @Override
    public void addReview(Review review, Long companyId) {
        Company company = companyService.getCompanyById(companyId).orElse(null);
        if(company!=null){
            review.setCompany(company);
             reviewRepo.save(review);
        }
    }

}
