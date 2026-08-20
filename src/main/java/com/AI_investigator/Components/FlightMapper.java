package com.AI_investigator.Components;

import com.AI_investigator.dto.GetFlightResponseDTO;
import com.AI_investigator.model.Flight;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FlightMapper {

    public GetFlightResponseDTO toDTO(Flight flight) {

        return new GetFlightResponseDTO(flight.getId(), flight.getFlightNumber(), flight.getDepartureSector(), flight.getDestinationSector(), flight.getDepartureTime(), flight.getArrivalTime(), flight.getCurrentPrice(), flight.getBaggageAllowance(), flight.getBasePrice());
    }

    public List<GetFlightResponseDTO> toDTO(List<Flight> flights) {
        return flights.stream().map(this::toDTO).toList();
    }
}
