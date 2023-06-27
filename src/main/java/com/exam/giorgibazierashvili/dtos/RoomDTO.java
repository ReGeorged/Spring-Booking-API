package com.exam.giorgibazierashvili.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoomDTO {
    private Long hotelId;
    private Long roomId;
    private BigDecimal pricePerDay;
}
