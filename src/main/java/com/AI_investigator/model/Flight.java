package com.AI_investigator.model;

import com.AI_investigator.dto.enums.DepartureSectorEnum;
import com.AI_investigator.dto.enums.DestinationSectorEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String flightNumber;
//    private String airline;

    @Enumerated(EnumType.STRING)
    private DepartureSectorEnum departureSector;

    @Enumerated(EnumType.STRING)
    private DestinationSectorEnum destinationSector;

    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;

    private BigDecimal price;

    private Integer availableSeats;
    private Integer totalSeats;

    @Enumerated(EnumType.STRING)
    private FlightStatus status;
}
