package com.exam.giorgibazierashvili.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "ROOMS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomEntity extends AppEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROOM_ID", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "HOTEL_ID")
    private HotelEntity hotel;

    @Column(name = "PRICE_PER_DAY")
    private BigDecimal pricePerDay;
}
