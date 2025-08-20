package com.example.uber.demo.controller;

import com.example.entity.models.Driver;
import com.example.uber.demo.dtos.CreatedDriverResponseDto;
import com.example.uber.demo.dtos.DriverDto;

import com.example.uber.demo.services.DriverService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DriverController {


    private DriverService driverService;
    public DriverController(DriverService driverService){
        this.driverService = driverService;
    }

    @PostMapping(path = "/driver")
    public ResponseEntity<?> createDriver(@RequestBody DriverDto  driverDto) {
               Driver driver= driverService.createDriver(driverDto);
               return new ResponseEntity<>(CreatedDriverResponseDto.createDriverResponseDto(driver), HttpStatus.CREATED);

    }
}
