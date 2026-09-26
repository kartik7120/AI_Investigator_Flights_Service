package com.AI_investigator.dto;

public record BookingDraftPassengerRequest(
        String firstName,
        String lastName,
        String dateOfBirth,
        String gender,
        String nationality,
        String email,
        String phoneNumber
) {
}
