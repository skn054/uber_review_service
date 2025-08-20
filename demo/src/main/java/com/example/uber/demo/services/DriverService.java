package com.example.uber.demo.services;

import com.example.entity.models.Driver;
import com.example.uber.demo.dtos.DriverDto;

import com.example.uber.demo.repository.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DriverService {

    private final DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public Driver createDriver(DriverDto driverDto) {
        Driver driver = DriverDto.createDriverFromDto(driverDto);
        return driverRepository.save(driver);
    }
}
