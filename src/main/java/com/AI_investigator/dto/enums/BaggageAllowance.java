package com.AI_investigator.dto.enums;

import lombok.Getter;

@Getter
public enum BaggageAllowance {

    DOMESTIC_ECONOMY(15, 7), DOMESTIC_PREMIUM_ECONOMY(25, 7), DOMESTIC_BUSINESS(35, 10),

    INTERNATIONAL_ECONOMY(20, 7), INTERNATIONAL_PREMIUM_ECONOMY(35, 10), INTERNATIONAL_BUSINESS(35, 10);

    private final int checkInBaggageAllowance;
    private final int cabinBaggageAllowance;

    BaggageAllowance(int checkInBaggageAllowance, int cabinBaggageAllowance) {

        this.checkInBaggageAllowance = checkInBaggageAllowance;
        this.cabinBaggageAllowance = cabinBaggageAllowance;
    }
}
