package com.example.uber.demo.dtos;



import com.example.entity.models.Review;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class ReviewDto {

    private String content;
    private Double rating;
    private Long bookingId;



    public List<ReviewDto> createReviewDtoFromListReview(List<Review> reviews){
            List<ReviewDto> reviewDtos = new ArrayList<>();
            for(Review review: reviews){
                ReviewDto reviewDto = new ReviewDto();
                reviewDto.setContent(review.getContent());
                reviewDto.setRating(review.getRating());
                reviewDto.setBookingId(review.getBooking().getId());
                reviewDtos.add(reviewDto);
            }

            return reviewDtos;
    }

    public ReviewDto createReviewDtoFromReview(Review review){
        ReviewDto reviewDto = new ReviewDto();
        reviewDto.setBookingId(review.getBooking().getId());
        reviewDto.setRating(review.getRating());
        reviewDto.setContent(review.getContent());
        return  reviewDto;
    }


}
