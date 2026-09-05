package com.AI_investigator.model;

import com.AI_investigator.dto.enums.FareType;
import com.AI_investigator.dto.enums.SSREnum;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SSR {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private SSREnum type;

    private Integer quantity;

    @Enumerated(EnumType.STRING)
    private FareType fareType;

    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_id")
    private Flight flight;

    public SSR(Long id, SSREnum ssrEnum, int quantity, BigDecimal bigDecimal, Flight flight, FareType fareType) {
    }
}