package com.AI_investigator.dto;

import com.AI_investigator.dto.enums.FareType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlightSSRRequest {

    private int flightID;
    private String fareType;
}