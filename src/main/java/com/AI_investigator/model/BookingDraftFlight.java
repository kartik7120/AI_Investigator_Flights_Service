package com.AI_investigator.model;


import com.AI_investigator.dto.enums.FareType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@ToString
@Table(name = "booking_draft_flight")
public class BookingDraftFlight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "draft_id", nullable = false)
    @ToString.Exclude
    private BookingDraft draft;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "flight_id", nullable = false)
    @ToString.Exclude
    private Flight flight;

    @Enumerated(EnumType.STRING)
    @Column(name = "fare_type", nullable = false)
    private FareType fareType;

    @Column(name = "fare_amount", nullable = false, precision = 12, scale = 2)
    private BigDecimal fareAmount;

    private int passengerCount;

    // getters and setters
}