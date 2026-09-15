package com.AI_investigator.service;

import com.AI_investigator.Repo.BookingDraftSeatRepo;
import com.AI_investigator.dto.BookingDraftSeatDto;
import com.AI_investigator.model.BookingDraft;
import com.AI_investigator.model.BookingDraftFlight;
import com.AI_investigator.model.BookingDraftSeat;
import com.AI_investigator.model.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingDraftSeatService {

    @Autowired
    private BookingDraftSeatRepo bookingDraftSeatRepo;

    @Autowired
    private BookingDraftService bookingDraftService;

    @Autowired
    private FlightService flightService;

    @Autowired
    private BookingDraftFlightService bookingDraftFlightService;

    @Autowired
    private SeatService seatService;

    public String createBookingSSRService(List<BookingDraftSeatDto> requests, String sessionID) {

        BookingDraft bookingDraft = bookingDraftService.getBookingDraftById(sessionID).orElseThrow();

        List<BookingDraftFlight> draftFlight = bookingDraft.getFlights();

        for (BookingDraftSeatDto bookingDraftSeat : requests) {

            BookingDraftSeat newBookingDraftSeat = new BookingDraftSeat();

            newBookingDraftSeat.setDraftFlight(
                    draftFlight.stream()
                            .filter(pre -> pre.getFlight().getId()
                                    .equals(bookingDraftSeat.getDraftFlightId()))
                            .findFirst()
                            .orElse(null)
            );

            Seat seat = seatService.getSeatById(Math.toIntExact(bookingDraftSeat.getSeatId()));

            newBookingDraftSeat.setSeat(seat);

            newBookingDraftSeat.setPrice(bookingDraftSeat.getPrice());

            bookingDraftSeatRepo.save(newBookingDraftSeat);

            bookingDraft.setSeatAmount(bookingDraftSeat.getPrice().add(bookingDraft.getSeatAmount()));

            bookingDraftService.saveBookingDraft(bookingDraft);
        }

        return "Seat Draft Created Successfully";
    }
}
