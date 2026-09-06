package com.AI_investigator.model;

import com.AI_investigator.dto.enums.FareType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Price {

    @Enumerated(EnumType.STRING)
    private FareType fareType;
    private BigDecimal basePrice;
    private BigDecimal currentPrice;

}