package com.AI_investigator.dto;

import com.AI_investigator.dto.enums.FareType;
import com.AI_investigator.dto.enums.SSREnum;

import java.math.BigDecimal;

public record SSRDto(Long id, String type, Integer quantity, String fareType, BigDecimal price,
                     Long flightID) {

}
