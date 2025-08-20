package com.example.uber.demo.dtos;



import com.example.entity.models.Driver;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DriverDto {

    private String driverName;
    private String licenseNumber;

    public static Driver createDriverFromDto(DriverDto driverDto){
        Driver driver = Driver.builder()
                .name(driverDto.getDriverName())
                .licenseNumber(driverDto.getLicenseNumber())
                .build();
        return driver;


    }

}
