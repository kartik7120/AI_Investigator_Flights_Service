package com.AI_investigator.utils;

import com.AI_investigator.dto.enums.FareType;
import com.AI_investigator.dto.enums.SSREnum;
import com.AI_investigator.model.Flight;
import com.AI_investigator.model.SSR;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class GenerateSSR {

    public List<SSR> createDefaultSSRs(Flight flight) {

        return List.of(
                new SSR(null, SSREnum.MEAL, 20, FareType.ECONOMY, new BigDecimal("350"), flight),
                new SSR(null, SSREnum.EXTRA_BAGGAGE, 50, FareType.ECONOMY, new BigDecimal("1500"), flight),
                new SSR(null, SSREnum.WHEELCHAIR, 5, FareType.ECONOMY, new BigDecimal("0"), flight),
                new SSR(null, SSREnum.PRIORITY_BOARDING, 30, FareType.ECONOMY, new BigDecimal("500"), flight)
        );
    }

    public List<SSR> createPremiumSSRs(Flight flight) {
        return List.of(
                new SSR(null, SSREnum.MEAL, 20, FareType.PREMIUM_ECONOMY, new BigDecimal("350"), flight),
                new SSR(null, SSREnum.EXTRA_BAGGAGE, 50, FareType.PREMIUM_ECONOMY, new BigDecimal("1500"), flight),
                new SSR(null, SSREnum.WHEELCHAIR, 5, FareType.PREMIUM_ECONOMY, new BigDecimal("0"), flight),
                new SSR(null, SSREnum.PRIORITY_BOARDING, 30, FareType.PREMIUM_ECONOMY, new BigDecimal("500"), flight),
                new SSR(null, SSREnum.PET_IN_CABIN, 30, FareType.PREMIUM_ECONOMY, new BigDecimal("500"), flight),
                new SSR(null, SSREnum.INFANT, 30, FareType.PREMIUM_ECONOMY, new BigDecimal("500"), flight)
        );
    }

    public List<SSR> createBusinessSSRs(Flight flight) {
        return List.of(
                new SSR(null, SSREnum.MEAL, 20, FareType.BUSINESS, new BigDecimal("350"), flight),
                new SSR(null, SSREnum.EXTRA_BAGGAGE, 50, FareType.BUSINESS, new BigDecimal("1500"), flight),
                new SSR(null, SSREnum.WHEELCHAIR, 5, FareType.BUSINESS, new BigDecimal("0"), flight),
                new SSR(null, SSREnum.PRIORITY_BOARDING, 30, FareType.BUSINESS, new BigDecimal("500"), flight),
                new SSR(null, SSREnum.PET_IN_CABIN, 30, FareType.BUSINESS, new BigDecimal("500"), flight),
                new SSR(null, SSREnum.INFANT, 30, FareType.BUSINESS, new BigDecimal("500"), flight),
                new SSR(null, SSREnum.SPORTS_EQUIPMENT, 30, FareType.BUSINESS, new BigDecimal("500"), flight),
                new SSR(null, SSREnum.EXTRA_LEGROOM, 30, FareType.BUSINESS, new BigDecimal("500"), flight)
        );
    }
}
