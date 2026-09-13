package com.AI_investigator.service;

import com.AI_investigator.Repo.BookingDraftFlightRepo;
import com.AI_investigator.Repo.BookingDraftRepo;
import com.AI_investigator.Repo.BookingDraftSSRRepo;
import com.AI_investigator.Repo.SSRRepo;
import com.AI_investigator.dto.BookingDraftSSRRequest;
import com.AI_investigator.model.BookingDraft;
import com.AI_investigator.model.BookingDraftFlight;
import com.AI_investigator.model.BookingDraftSSR;
import com.AI_investigator.model.SSR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class BookingDraftSSRService {

    @Autowired
    private BookingDraftRepo bookingDraftRepo;

    @Autowired
    private BookingDraftSSRRepo bookingDraftSSRRepo;

    @Autowired
    private BookingDraftFlightRepo bookingDraftFlightRepo;

    @Autowired
    private SSRRepo ssrRepo;

    public String createBookingDraftSSR(List<BookingDraftSSRRequest> requests, String sessionID) {

        BookingDraft draft = bookingDraftRepo
                .getBookingDraftBysessionId(sessionID);

        for (BookingDraftSSRRequest request : requests) {

            BookingDraftFlight draftFlight = bookingDraftFlightRepo
                    .findById(Math.toIntExact(request.getDraftFlightId()))
                    .orElseThrow(() -> new RuntimeException(
                            "Booking draft flight not found"
                    ));

            SSR ssr = ssrRepo
                    .findById(request.getSsrId()).orElseThrow(() -> new RuntimeException("SSR not found"));

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

            draft.setSsrAmount(draftSSR.getTotalPrice());

            bookingDraftSSRRepo.save(draftSSR);
            bookingDraftRepo.save(draft);
        }

        return "Draft SSR created";
    }

}
