package com.example.uber.demo.dtos;


import com.example.entity.models.BookingStatus;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingDto {


    private BookingStatus bookingStatus;
    private Long distance;
    private Date startTime;
    private Long passengerId;
    private Long driverId;


}
