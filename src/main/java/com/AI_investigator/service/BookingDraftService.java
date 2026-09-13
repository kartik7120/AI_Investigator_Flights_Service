package com.AI_investigator.service;

import com.AI_investigator.Repo.BookingDraftRepo;
import com.AI_investigator.Repo.FlightRepo;
import com.AI_investigator.dto.BookingDraftFlightRequest;
import com.AI_investigator.dto.enums.FareType;
import com.AI_investigator.model.BookingDraft;
import com.AI_investigator.model.BookingDraftFlight;
import com.AI_investigator.model.Flight;
import com.AI_investigator.model.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class BookingDraftService {

    @Autowired
    private BookingDraftRepo bookingDraftRepo;

    @Autowired
    private FlightRepo flightRepo;

    public void createBookingDraft(
            List<BookingDraftFlightRequest> requests,
            BookingDraft bookingDraft) {

        for (BookingDraftFlightRequest request : requests) {

            Flight flight = flightRepo.findById(Math.toIntExact(request.getFlightId()))
                    .orElseThrow(() ->
                            new RuntimeException("Flight not found"));

            BookingDraftFlight draftFlight = new BookingDraftFlight();

            draftFlight.setDraft(bookingDraft);
            draftFlight.setFlight(flight);
            draftFlight.setFareType(request.getFareType());

            BigDecimal fareAmount =
                    getFareAmount(flight, request.getFareType());

            draftFlight.setFareAmount(fareAmount);

            bookingDraft.getFlights().add(draftFlight);
        }

        bookingDraftRepo.save(bookingDraft);
    }

    private BigDecimal getFareAmount(Flight flight, FareType fareType) {

        return flight.getCurrentPrice()
                .stream()
                .filter(price -> price.getFareType() == fareType)
                .findFirst()
                .map(Price::getCurrentPrice)
                .orElseThrow(() ->
                        new RuntimeException("Fare not found for " + fareType));
    }

    public Optional<BookingDraft> getBookingDraftById(String sessionID) {

        return Optional.ofNullable(bookingDraftRepo.getBookingDraftBysessionId(sessionID));
    }
}
