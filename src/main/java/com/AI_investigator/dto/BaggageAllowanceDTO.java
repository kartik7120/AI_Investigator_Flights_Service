package com.AI_investigator.dto;

public record BaggageAllowanceDTO(

        String fareType,
        int cabinBaggageAllowance,
        int checkInBaggageAllowance
) {
}
