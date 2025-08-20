package com.example.uber.demo.services;


import com.example.entity.models.Passenger;
import com.example.uber.demo.dtos.PassengerDto;

import com.example.uber.demo.repository.PassengerRepository;
import org.springframework.stereotype.Service;

@Service
public class PassengerService {

    private final PassengerRepository passengerRepository;

    public PassengerService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }


    public Passenger createPassenger(PassengerDto passengerDto){
        Passenger passenger =PassengerDto.CreatePassengerFromPassengerDto(passengerDto);
        return passengerRepository.save(passenger);
    }
}
