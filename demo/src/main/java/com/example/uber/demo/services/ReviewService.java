package com.example.uber.demo.services;

import com.example.entity.models.Booking;
import com.example.entity.models.Review;
import com.example.uber.demo.dtos.ReviewDto;

import com.example.uber.demo.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    private ReviewRepository reviewRepository;
    private BookingService bookingService;
    public ReviewService(ReviewRepository reviewRepository,BookingService bookingService){
        this.bookingService = bookingService;
        this.reviewRepository = reviewRepository;
    }
    public Review getReviewById(Long id) throws Exception {
        Optional<Review> reviewOptional= reviewRepository.findById(id);
        if(reviewOptional.isPresent()){
            return reviewOptional.get();
        }

        throw new Exception("Review not found");
    }

    public List<Review> getAllReviews(){
        return reviewRepository.findAll();
    }


    public Review publishReview(ReviewDto reviewDto) {
        Booking booking = bookingService.findBookingById(reviewDto.getBookingId());
        Review review = Review.builder()
                .content(reviewDto.getContent())
                .rating(reviewDto.getRating())
                .booking(booking)
                .build();
        return reviewRepository.save(review);



    }
}
