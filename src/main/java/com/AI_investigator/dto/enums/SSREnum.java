package com.AI_investigator.dto.enums;

public enum SSREnum {

    MEAL("Meal"), EXTRA_BAGGAGE("Extra Baggage"), WHEELCHAIR("Wheelchair Assistance"), PRIORITY_BOARDING("Priority Boarding"), EXTRA_LEGROOM("Extra Legroom"), SPORTS_EQUIPMENT("Sports Equipment"), INFANT("Infant"), PET_IN_CABIN("Pet in Cabin");

    private final String fullName;

    SSREnum(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }
}