package com.example.uber.demo.services;

import com.example.entity.models.Booking;
import com.example.uber.demo.dtos.BookingDto;

import com.example.uber.demo.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookingService {

    private BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository){
        this.bookingRepository = bookingRepository;
    }


    public Booking findBookingById(Long id){
        Optional<Booking> optionalBooking =  bookingRepository.findById(id);
        if(optionalBooking.isPresent()){
            return optionalBooking.get();
        }
        throw new RuntimeException("Booking Not Found");
    }

    public Booking createBooking(BookingDto bookingDto){
        Booking booking = new Booking();
        booking.setBookingStatus(bookingDto.getBookingStatus());
        booking.setCreatedAt(bookingDto.getStartTime());
        booking.setTotalDistance(bookingDto.getDistance());
        return bookingRepository.save(booking);
    }
}
