package com.siva.firstjobapp.reviews.controller;

import com.siva.firstjobapp.reviews.model.Review;
import com.siva.firstjobapp.reviews.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/company/{id}")
public class ReviewController {

    ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Review>> findAll(){
        return new ResponseEntity<>(reviewService.findAll(),HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody Review review){
        reviewService.createJob(review);
        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Optional<Review>> add(@PathVariable Long id){
        Optional<Review> job = reviewService.getJobById(id);
        if (job !=null){
            return new ResponseEntity<>(job, HttpStatus.OK);
        }
        return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id){
        boolean deleted = reviewService.deleteById(id);
        if(deleted == true){
            return new ResponseEntity<>(deleted, HttpStatus.OK);
        }

        return new ResponseEntity<>(deleted, HttpStatus.NOT_FOUND);

    }

    @PutMapping("/jobs/{id}")
    public ResponseEntity<Optional<Review>> updateById(@RequestBody Review review, @PathVariable Long id){
        Optional<Review> update = reviewService.updateById(review,id);
        if(update != null){
            return new ResponseEntity<>(update, HttpStatus.OK);
        }

        return new ResponseEntity<>(update, HttpStatus.NOT_FOUND);

    }

}
