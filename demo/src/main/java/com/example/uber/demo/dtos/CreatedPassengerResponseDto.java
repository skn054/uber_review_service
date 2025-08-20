package com.example.uber.demo.dtos;


import com.example.entity.models.Passenger;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreatedPassengerResponseDto {

    private String passengerName;
    private Long id;

    public static CreatedPassengerResponseDto createResponse(Passenger passenger){
        CreatedPassengerResponseDto passengerResponseDto = CreatedPassengerResponseDto.builder()
                .passengerName(passenger.getName())
                .id(passenger.getId())
                .build();
        return  passengerResponseDto;

    }
}
