package com.exam.giorgibazierashvili.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "BOOKINGS")
public class BookingEntity extends AppEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOOKING_ID", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "ROOM_ID")
    private RoomEntity room;
    @Column(name = "START_DATE")
    private Date startDate;
    @Column(name = "END_DATE")
    private Date endDate;
    @Column(name = "USER")
    private String user;
}
