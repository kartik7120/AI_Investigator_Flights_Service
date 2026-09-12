package com.AI_investigator.Controllers;

import com.AI_investigator.Components.FlightMapper;
import com.AI_investigator.Components.SSRMapper;
import com.AI_investigator.dto.FlightSSRRequest;
import com.AI_investigator.dto.GetFlightRequest;
import com.AI_investigator.dto.GetFlightResponseDTO;
import com.AI_investigator.dto.SSRDto;
import com.AI_investigator.dto.enums.FareType;
import com.AI_investigator.dto.enums.SSREnum;
import com.AI_investigator.model.Flight;
import com.AI_investigator.model.SSR;
import com.AI_investigator.service.FlightService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:6006")
public class FlightApi {

    @Autowired
    private FlightService flightService;

    @Autowired
    private FlightMapper flightMapper;

    @Autowired
    private SSRMapper ssrMapper;

    @PostMapping("/seedFlights")
    public ResponseEntity<List<Flight>> seedFlights() {

        List<Flight> flights = flightService.generateAndSeedFlights();
        return ResponseEntity.ok(flights);
    }

    @PostMapping("/getFlights")
    public ResponseEntity<List<GetFlightResponseDTO>> getFlights(@RequestBody GetFlightRequest getFlightRequest) {

        List<Flight> flights;

        flights = flightService.getFlights(getFlightRequest);

        List<GetFlightResponseDTO> flightsResponse = flightMapper.toDTO(flights);

        return ResponseEntity.ok(flightsResponse);
    }

    @PostMapping("/getFlightSSRs")
    public ResponseEntity<List<SSRDto>> getFlightSSRs(@RequestBody FlightSSRRequest flightSSRRequest) {

        List<SSR> ssrs;

        Long l = (long) flightSSRRequest.getFlightID();

        ssrs = flightService.getFlightSSR(flightSSRRequest.getFlightID(), FareType.valueOf(flightSSRRequest.getFareType()));

        List<SSRDto> ssrDtos = ssrMapper.getSSRDtos(ssrs);

        return ResponseEntity.ok(ssrDtos);
    }

    @GetMapping("/getFlight/{flightID}")
    public ResponseEntity<GetFlightResponseDTO> getFlightDetails(@PathVariable String flightID) {

        int fId = Integer.parseInt(flightID);

        Flight f = flightService.getFlight(fId);

        GetFlightResponseDTO getFlightResponseDTO = flightMapper.toDTO(f);

        return ResponseEntity.ok(getFlightResponseDTO);
    }

    @PostMapping("/bookFlightInvestory")
    public ResponseEntity<String> bookFlightInventory(@RequestBody FlightInvestory flightInventory) {


    }

}