package com.AI_investigator.dto;

import com.AI_investigator.dto.enums.BaggageAllowance;
import com.AI_investigator.dto.enums.DepartureSectorEnum;
import com.AI_investigator.dto.enums.DestinationSectorEnum;
import com.AI_investigator.model.Price;

import java.time.LocalDateTime;
import java.util.List;

public record GetFlightResponseDTO(
        Long id,
        String flightNumber,
        DepartureSectorEnum departureSector,
        DestinationSectorEnum destinationSector,
        LocalDateTime departureTime,
        LocalDateTime arrivalTime,
        List<Price> currentPrice,
        BaggageAllowance[] baggageAllowance,
        List<Price> basePrice
) {
}