package com.AI_investigator.service;

import com.AI_investigator.Repo.BookingDraftPassengerRepo;
import com.AI_investigator.dto.BookingDraftPassengerRequest;
import com.AI_investigator.model.BookingDraft;
import com.AI_investigator.model.BookingDraftPassenger;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingDraftPassengerService {

    @Autowired
    private BookingDraftPassengerRepo bookingDraftPassengerRepo;

    @Autowired
    private BookingDraftService bookingDraftService;

    public void save(BookingDraftPassenger bookingDraftPassenger) {

        bookingDraftPassengerRepo.save(bookingDraftPassenger);
    }

    public void save(String sessionID, @NonNull List<BookingDraftPassengerRequest> bookingDraftPassengers) {

        BookingDraft bookingDraft = bookingDraftService.getBookingDraftById(
                sessionID
        ).orElseThrow();

        for (BookingDraftPassengerRequest bookingDraftPassenger : bookingDraftPassengers) {

            BookingDraftPassenger bookingDraftPassengerEntity = getBookingDraftPassenger(bookingDraftPassenger, bookingDraft);

            bookingDraftPassengerRepo.save(bookingDraftPassengerEntity);
        }
    }

    private static @NonNull BookingDraftPassenger getBookingDraftPassenger(BookingDraftPassengerRequest bookingDraftPassenger, BookingDraft bookingDraft) {
        BookingDraftPassenger bookingDraftPassengerEntity = new BookingDraftPassenger();
        bookingDraftPassengerEntity.setBookingDraft(bookingDraft);
        bookingDraftPassengerEntity.setFirstName(bookingDraftPassenger.gender());
        bookingDraftPassengerEntity.setLastName(bookingDraftPassenger.lastName());
        bookingDraftPassengerEntity.setFirstName(bookingDraftPassenger.firstName());
        bookingDraftPassengerEntity.setDateOfBirth(bookingDraftPassenger.dateOfBirth());
        return bookingDraftPassengerEntity;
    }
}
