package com.AI_investigator.service;

import com.AI_investigator.Repo.FlightRepo;
import com.AI_investigator.dto.GetFlightRequest;
import com.AI_investigator.dto.enums.FareType;
import com.AI_investigator.model.Flight;
import com.AI_investigator.model.SSR;
import com.AI_investigator.seeder.FlightDataSeeder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepo flightRepo;

    @Autowired
    private FlightDataSeeder flightDataSeeder;

    public List<Flight> generateAndSeedFlights() {

        List<Flight> flights = flightDataSeeder.generateFakeFlights();

        this.flightRepo.saveAll(flights);

        return flights;
    }

    public List<Flight> getFlights(GetFlightRequest request) {

        LocalDateTime departureDate = LocalDate.parse(request.departure_date).atStartOfDay();
        LocalDateTime returnDate = null;

        if (request.return_date != null) {
            returnDate = LocalDate.parse(request.return_date).atStartOfDay();
        } else {
            returnDate = LocalDate.parse(request.departure_date).plusDays(6).atStartOfDay();
        }

        return flightRepo.getFlights(
                request.departure_sector,
                request.destination_sector,
                departureDate,
                returnDate
        );
    }

    public List<SSR> getFlightSSR(Long flightID, FareType fareType) {

        return flightRepo.findByFlightIdAndFareType(flightID, fareType);
    }
}
