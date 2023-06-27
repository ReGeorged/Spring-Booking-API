package com.exam.giorgibazierashvili.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO  {
    private Long roomId;
    private Date startDate;
    private Date endDate;
    private String user;

}
