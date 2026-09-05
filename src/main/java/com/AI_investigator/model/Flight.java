package com.AI_investigator.model;

import com.AI_investigator.dto.enums.*;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String flightNumber;

    @Enumerated(EnumType.STRING)
    private DepartureSectorEnum departureSector;

    @Enumerated(EnumType.STRING)
    private DestinationSectorEnum destinationSector;

    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;

    // Base fare in INR
    @ElementCollection
    private List<Price> basePrice;
    @ElementCollection
    private List<Price> currentPrice;

//    private Integer availableSeats;
//    private Integer totalSeats;

    // Baggage
    @Enumerated(EnumType.STRING)
    private BaggageAllowance[] baggageAllowance;

    @Enumerated(EnumType.STRING)
    private FareType[] fareType;

    @Enumerated(EnumType.STRING)
    private FlightStatus status;

    @OneToMany(
            mappedBy = "flight",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Seat> seatMap;

    @OneToMany(
            mappedBy = "flight",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<SSR> ssrList;
}
