package com.exam.giorgibazierashvili.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "HOTELS")
@Data

public class HotelEntity extends AppEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "HOTEL_ID", nullable = false)
    private Long id;
    @Column(name = "HOTEL_NAME")
    private String hotelName;

}
