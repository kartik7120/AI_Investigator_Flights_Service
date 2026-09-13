package com.AI_investigator.dto;


import com.AI_investigator.dto.enums.FareType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingDraftFlightRequest {

    private Long flightId;
    private FareType fareType;

    // getters and setters
}