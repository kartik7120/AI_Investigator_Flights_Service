package com.AI_investigator.service;

import com.AI_investigator.Repo.BookingDraftRepo;
import com.AI_investigator.model.BookingDraft;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookingDraftService {

    @Autowired
    private BookingDraftRepo bookingDraftRepo;

    public void createBookingDraft(BookingDraft bookingDraft) {
        bookingDraftRepo.save(bookingDraft);
    }

    public Optional<BookingDraft> getBookingDraftById(String sessionID) {

        return Optional.ofNullable(bookingDraftRepo.getBookingDraftBysessionId(sessionID));
    }
}
