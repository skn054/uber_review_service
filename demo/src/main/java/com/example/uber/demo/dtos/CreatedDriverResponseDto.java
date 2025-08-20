package com.example.uber.demo.dtos;


import com.example.entity.models.Driver;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreatedDriverResponseDto {
    private Long id;
    private String driverName;
    private String licenseNumber;


    public static CreatedDriverResponseDto createDriverResponseDto(Driver driver){
        CreatedDriverResponseDto createdDriverResponseDto = CreatedDriverResponseDto.builder()
                .driverName(driver.getName())
                .licenseNumber(driver.getLicenseNumber())
                .id(driver.getId())
                .build();
        return createdDriverResponseDto;
    }


}
