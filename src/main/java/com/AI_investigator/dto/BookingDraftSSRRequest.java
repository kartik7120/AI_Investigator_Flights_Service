package com.AI_investigator.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingDraftSSRRequest {

    private Long draftFlightId;
    private Long ssrId;
    private int quantity;

    // getters and setters
}