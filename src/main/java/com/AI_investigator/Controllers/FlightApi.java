package com.AI_investigator.Controllers;

import com.AI_investigator.Components.FlightMapper;
import com.AI_investigator.Components.SSRMapper;
import com.AI_investigator.dto.*;
import com.AI_investigator.dto.enums.FareType;
import com.AI_investigator.dto.enums.SSREnum;
import com.AI_investigator.model.*;
import com.AI_investigator.service.BookingDraftService;
import com.AI_investigator.service.FlightService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:6006")
public class FlightApi {

    @Autowired
    private FlightService flightService;

    @Autowired
    private BookingDraftService bookingDraftService;

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

    @PostMapping("/generateSessionID")
    public ResponseEntity<String> generateSessionID() {

        String sessionID = UUID.randomUUID().toString();

        BookingDraft bookingDraft = new BookingDraft();
        bookingDraft.setSessionId(sessionID);
        bookingDraft.setStatus(BookingDraftStatus.ACTIVE);
        bookingDraftService.createBookingDraft(bookingDraft);
        bookingDraft.setExpiresAt(LocalDateTime.now().plusMinutes(30));

        return ResponseEntity.ok(sessionID);
    }

    @PostMapping("/bookingDraft/{sessionID}/flights")
    public ResponseEntity<String> bookingDraft(
            @PathVariable String sessionID,
            @RequestBody List<BookingDraftFlightRequest> requests) {


        BookingDraft draft = bookingDraftService
                .getBookingDraftById(sessionID)
                .orElseThrow(() -> new RuntimeException("Booking draft not found"));

        bookingDraftService.createBookingDraft(draft);

        return ResponseEntity.ok("Flights added to booking draft");
    }

    @PostMapping("/bookingDraft/{sessionID}/ssrs")
    public ResponseEntity<String> bookingDraftSSRs(
            @PathVariable String sessionID,
            @RequestBody List<BookingDraftSSRRequest> requests) {

        BookingDraft draft = bookingDraftRepository
                .findBySessionId(sessionID)
                .orElseThrow(() -> new RuntimeException("Booking draft not found"));

        for (BookingDraftSSRRequest request : requests) {

            BookingDraftFlight draftFlight = bookingDraftFlightRepository
                    .findById(request.getDraftFlightId())
                    .orElseThrow(() -> new RuntimeException(
                            "Booking draft flight not found"
                    ));

            SSR ssr = ssrRepository
                    .findById(request.getSsrId())
                    .orElseThrow(() -> new RuntimeException(
                            "SSR not found"
                    ));

            BookingDraftSSR draftSSR = new BookingDraftSSR();

            draftSSR.setDraftFlight(draftFlight);
            draftSSR.setSsr(ssr);
            draftSSR.setQuantity(request.getQuantity());

            // Price comes from DB, NOT from frontend
            BigDecimal unitPrice = ssr.getPrice();

            draftSSR.setUnitPrice(unitPrice);
            draftSSR.setTotalPrice(
                    unitPrice.multiply(
                            BigDecimal.valueOf(request.getQuantity())
                    )
            );

            bookingDraftSSRRepository.save(draftSSR);
        }

        return ResponseEntity.ok("SSRs added to booking draft");
    }
}