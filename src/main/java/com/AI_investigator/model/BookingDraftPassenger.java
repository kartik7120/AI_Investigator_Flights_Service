package com.AI_investigator.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "booking_draft_passenger")
public class BookingDraftPassenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_draft_id", nullable = false)
    private BookingDraft bookingDraft;

    private String firstName;

    private String lastName;

    private String dateOfBirth;

    private String gender;

    private String nationality;

    private String email;

    private String phoneNumber;

    // You can add these later
    // private String dateOfBirth;
    // private String gender;
    // private String nationality;
}