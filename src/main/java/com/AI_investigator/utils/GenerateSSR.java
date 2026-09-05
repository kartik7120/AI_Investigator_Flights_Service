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
                new SSR(null, SSREnum.MEAL, 20, new BigDecimal("350"), flight, FareType.ECONOMY),
                new SSR(null, SSREnum.EXTRA_BAGGAGE, 50, new BigDecimal("1500"), flight, FareType.ECONOMY),
                new SSR(null, SSREnum.WHEELCHAIR, 5, new BigDecimal("0"), flight, FareType.ECONOMY),
                new SSR(null, SSREnum.PRIORITY_BOARDING, 30, new BigDecimal("500"), flight, FareType.ECONOMY)
        );
    }

    public List<SSR> createPremiumSSRs(Flight flight) {
        return List.of(
                new SSR(null, SSREnum.MEAL, 20, new BigDecimal("350"), flight, FareType.PREMIUM_ECONOMY),
                new SSR(null, SSREnum.EXTRA_BAGGAGE, 50, new BigDecimal("1500"), flight, FareType.PREMIUM_ECONOMY),
                new SSR(null, SSREnum.WHEELCHAIR, 5, new BigDecimal("0"), flight, FareType.PREMIUM_ECONOMY),
                new SSR(null, SSREnum.PRIORITY_BOARDING, 30, new BigDecimal("500"), flight, FareType.PREMIUM_ECONOMY),
                new SSR(null, SSREnum.PET_IN_CABIN, 30, new BigDecimal("500"), flight, FareType.PREMIUM_ECONOMY),
                new SSR(null, SSREnum.INFANT, 30, new BigDecimal("500"), flight, FareType.PREMIUM_ECONOMY)
        );
    }

    public List<SSR> createBusinessSSRs(Flight flight) {
        return List.of(
                new SSR(null, SSREnum.MEAL, 20, new BigDecimal("350"), flight, FareType.BUSINESS),
                new SSR(null, SSREnum.EXTRA_BAGGAGE, 50, new BigDecimal("1500"), flight, FareType.BUSINESS),
                new SSR(null, SSREnum.WHEELCHAIR, 5, new BigDecimal("0"), flight, FareType.BUSINESS),
                new SSR(null, SSREnum.PRIORITY_BOARDING, 30, new BigDecimal("500"), flight, FareType.BUSINESS),
                new SSR(null, SSREnum.PET_IN_CABIN, 30, new BigDecimal("500"), flight, FareType.BUSINESS),
                new SSR(null, SSREnum.INFANT, 30, new BigDecimal("500"), flight, FareType.BUSINESS),
                new SSR(null, SSREnum.SPORTS_EQUIPMENT, 30, new BigDecimal("500"), flight, FareType.BUSINESS),
                new SSR(null, SSREnum.EXTRA_LEGROOM, 30, new BigDecimal("500"), flight, FareType.BUSINESS)
        );
    }
}
