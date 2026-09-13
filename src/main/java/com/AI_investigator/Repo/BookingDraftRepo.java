package com.AI_investigator.Repo;

import com.AI_investigator.model.BookingDraft;
import org.springframework.data.repository.CrudRepository;

public interface BookingDraftRepo extends CrudRepository<BookingDraft, String> {
    BookingDraft getBookingDraftBysessionId(String sessionID);
}
