package com.AI_investigator.service;

import com.AI_investigator.Repo.BookingDraftFlightRepo;
import com.AI_investigator.Repo.FlightRepo;
import com.AI_investigator.dto.BookingDraftFlightRequest;
import com.AI_investigator.dto.enums.FareType;
import com.AI_investigator.model.BookingDraft;
import com.AI_investigator.model.BookingDraftFlight;
import com.AI_investigator.model.Flight;
import com.AI_investigator.model.Price;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@Getter
@Setter
public class BookingDraftFlightService {

    @Autowired
    private BookingDraftFlightRepo bookingDraftFlightRepo;

    @Autowired
    private FlightRepo flightRepo;

    public void createBookingDraftFlight(List<BookingDraftFlightRequest> requests, BookingDraft draft) {

        for (BookingDraftFlightRequest request : requests) {


            Flight flight = flightRepo
                    .findById(Math.toIntExact(request.getFlightId()))
                    .orElseThrow(() -> new RuntimeException(
                            "Flight not found: " + request.getFlightId()
                    ));

            BookingDraftFlight draftFlight = new BookingDraftFlight();

            draftFlight.setDraft(draft);
            draftFlight.setFlight(flight);
            draftFlight.setFareType(request.getFareType());

            // IMPORTANT:
            // Get price from database, not from frontend
            BigDecimal fareAmount =
                    getFareAmount(flight, request.getFareType());

            draftFlight.setFareAmount(fareAmount);

            bookingDraftFlightRepo.save(draftFlight);
        }
    }

    private BigDecimal getFareAmount(Flight flight, FareType fareType) {

        List<Price> price = flight.getCurrentPrice();

        for (Price price1 : price) {
            if (price1.getFareType().equals(fareType)) {
                return price1.getCurrentPrice();
            }
        }

        return null;
    }
}
