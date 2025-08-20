package com.example.uber.demo.controller;

import com.example.entity.models.Passenger;
import com.example.uber.demo.dtos.CreatedPassengerResponseDto;
import com.example.uber.demo.dtos.PassengerDto;
import com.example.uber.demo.dtos.ReviewDto;

import com.example.uber.demo.services.PassengerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PassengerController {

    private PassengerService passengerService;
    public PassengerController(PassengerService passengerService){
        this.passengerService = passengerService;
    }

    @PostMapping(path = "/passenger")
    public ResponseEntity<?> createPassenger(@RequestBody PassengerDto passengerDto){
        Passenger passenger =  passengerService.createPassenger(passengerDto);
        return new ResponseEntity<>(CreatedPassengerResponseDto.createResponse(passenger), HttpStatus.CREATED);
    }
}
