package com.AI_investigator.Controllers;

import com.AI_investigator.dto.GetFlightRequest;
import com.AI_investigator.model.Flight;
import com.AI_investigator.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FlightApi {

    @Autowired
    private FlightService flightService;

    @PostMapping("/seedFlights")
    public ResponseEntity<List<Flight>> seedFlights() {

        List<Flight> flights = flightService.generateAndSeedFlights();
        return ResponseEntity.ok(flights);
    }

    @PostMapping("/getFlights")
    public String getFlights(@RequestBody GetFlightRequest getFlightRequest) {

        return "";
    }
}
