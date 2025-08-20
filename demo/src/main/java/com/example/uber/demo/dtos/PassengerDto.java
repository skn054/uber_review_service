package com.example.uber.demo.dtos;


import com.example.entity.models.Passenger;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PassengerDto {

    private String passengerName;

    public static Passenger CreatePassengerFromPassengerDto(PassengerDto passengerDto){
        Passenger passenger = Passenger.builder()
                .name(passengerDto.getPassengerName())
                .build();
        return passenger;
    }

}
