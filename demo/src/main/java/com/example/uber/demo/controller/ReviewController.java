package com.example.uber.demo.controller;

import com.example.entity.models.Review;
import com.example.uber.demo.dtos.ReviewDto;


import com.example.uber.demo.services.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
public class ReviewController {

    private ReviewService reviewService;
    private final ReviewDto reviewDto;
    public ReviewController(ReviewService reviewService,ReviewDto reviewDto) {
        this.reviewService = reviewService;
        this.reviewDto = reviewDto;
    }

    @RequestMapping(path = "/reviews", method = RequestMethod.GET)
    public ResponseEntity<List<ReviewDto>> getAllReviews(){
        List<Review> reviews = reviewService.getAllReviews();
        List<ReviewDto> reviewDtos =  reviewDto.createReviewDtoFromListReview(reviews);
        return new ResponseEntity<>(reviewDtos, HttpStatus.OK);
    }

    @GetMapping(path = "/review/{id}")
    public ResponseEntity<?> getReviewById(@PathVariable Long id) throws Exception {
        Review review = reviewService.getReviewById(id);
        ReviewDto reviewDto = new ReviewDto();
        return new ResponseEntity<>(reviewDto.createReviewDtoFromReview(review),HttpStatus.OK);
    }

    @PostMapping(path = "/review")
    public ResponseEntity<?> publishReview(@RequestBody ReviewDto reviewDto){
        Review review =reviewService.publishReview(reviewDto);
        return  new ResponseEntity<>(reviewDto.createReviewDtoFromReview(review),HttpStatus.CREATED);

    }


}
