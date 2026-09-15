package com.AI_investigator.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class BookingDraftSeatDto {

    private Long seatId;
    private String seatNumber;
    private BigDecimal price;
    private Long draftFlightId;
}