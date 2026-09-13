package com.AI_investigator.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "booking_draft")
public class BookingDraft {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "session_id", nullable = false, unique = true)
    private String sessionId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BookingDraftStatus status;

    @Column(name = "base_fare", nullable = false, precision = 12, scale = 2)
    private BigDecimal baseFare = BigDecimal.ZERO;

    @Column(name = "seat_amount", nullable = false, precision = 12, scale = 2)
    private BigDecimal seatAmount = BigDecimal.ZERO;

    @Column(name = "ssr_amount", nullable = false, precision = 12, scale = 2)
    private BigDecimal ssrAmount = BigDecimal.ZERO;

    @Column(name = "tax_amount", nullable = false, precision = 12, scale = 2)
    private BigDecimal taxAmount = BigDecimal.ZERO;

    @Column(name = "total_amount", nullable = false, precision = 12, scale = 2)
    private BigDecimal totalAmount = BigDecimal.ZERO;

    @Column(nullable = false)
    private String currency = "INR";

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "expires_at", nullable = false)
    private LocalDateTime expiresAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @OneToMany(
            mappedBy = "draft",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<BookingDraftFlight> flights = new ArrayList<>();

    // getters and setters
}