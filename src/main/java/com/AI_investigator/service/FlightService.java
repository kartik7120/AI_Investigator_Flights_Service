package com.AI_investigator.service;

import com.AI_investigator.Repo.FlightRepo;
import com.AI_investigator.model.Flight;
import com.AI_investigator.seeder.FlightDataSeeder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
