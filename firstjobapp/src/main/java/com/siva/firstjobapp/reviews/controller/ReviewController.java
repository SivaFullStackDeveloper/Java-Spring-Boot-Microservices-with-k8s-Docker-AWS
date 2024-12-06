package com.siva.firstjobapp.reviews.controller;

import com.siva.firstjobapp.reviews.model.Review;
import com.siva.firstjobapp.reviews.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/company/{companyID}")
public class ReviewController {

    ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> findAll(@PathVariable Long companyID){
        return new ResponseEntity<>(reviewService.findByCompanyId(companyID),HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<?> addReview(@RequestBody Review review,@PathVariable Long companyID){
        reviewService.addReview(review,companyID);
        return new ResponseEntity<>("Successfully added review",HttpStatus.OK);
    }


    @GetMapping("/review/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long reviewId,@PathVariable Long companyID){
        Review review = reviewService.getReview(companyID, reviewId);
        return new ResponseEntity<>(review,HttpStatus.OK);
    }


    @PutMapping("/review/{reviewId}")
    public ResponseEntity<Review> updateReview(@PathVariable Long reviewId,@PathVariable Long companyID,@RequestBody Review review1){
        Review review = reviewService.updateReview(companyID, reviewId,review1);
        return new ResponseEntity<>(review,HttpStatus.OK);
    }

    @DeleteMapping("/review/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long reviewId,@PathVariable Long companyID){
         reviewService.deleteReview(companyID, reviewId);
        return new ResponseEntity<>("Review is deleted SuccessFully",HttpStatus.OK);
    }

}
