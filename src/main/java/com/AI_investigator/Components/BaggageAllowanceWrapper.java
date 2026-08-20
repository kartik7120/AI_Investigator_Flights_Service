package com.AI_investigator.Components;

import com.AI_investigator.dto.BaggageAllowanceDTO;
import com.AI_investigator.dto.enums.BaggageAllowance;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BaggageAllowanceWrapper {

    public BaggageAllowanceDTO toDTO(BaggageAllowance baggageAllowance) {

        return new BaggageAllowanceDTO(
                baggageAllowance.name(), baggageAllowance.getCabinBaggageAllowance(), baggageAllowance.getCheckInBaggageAllowance()
        );
    }

    public List<BaggageAllowanceDTO> toDTO(List<BaggageAllowance> baggageAllowances) {
        return baggageAllowances.stream().map(this::toDTO).toList();
    }
}
