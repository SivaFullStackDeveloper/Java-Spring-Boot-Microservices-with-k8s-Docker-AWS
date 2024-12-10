package com.siva.reviewMs.reviews.controller;


import com.siva.reviewMs.reviews.model.Review;
import com.siva.reviewMs.reviews.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public ResponseEntity<List<Review>> findAll(@RequestParam Long companyId){
        return new ResponseEntity<>(reviewService.findByCompanyId(companyId),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addReview(@RequestBody Review review,@RequestParam Long companyId){
        reviewService.addReview(review,companyId);
        return new ResponseEntity<>("Successfully added review",HttpStatus.OK);
    }


    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long reviewId){
        Review review = reviewService.getReview( reviewId);
        return new ResponseEntity<>(review,HttpStatus.OK);
    }


    @PutMapping("/{reviewId}")
    public ResponseEntity<Review> updateReview(@PathVariable Long reviewId,@RequestBody Review review1){
        Review review = reviewService.updateReview( reviewId,review1);
        return new ResponseEntity<>(review,HttpStatus.OK);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long reviewId){
         reviewService.deleteReview( reviewId);
        return new ResponseEntity<>("Review is deleted SuccessFully",HttpStatus.OK);
    }

}
