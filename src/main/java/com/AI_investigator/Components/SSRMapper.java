package com.AI_investigator.Components;

import com.AI_investigator.dto.GetFlightResponseDTO;
import com.AI_investigator.dto.SSRDto;
import com.AI_investigator.model.SSR;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SSRMapper {

    public SSRDto getSSRDto(SSR ssr) {
        return new SSRDto(
                ssr.getId(),
                ssr.getType().getFullName(),
                ssr.getQuantity(),
                ssr.getFareType().name(),
                ssr.getPrice(),
                ssr.getFlight().getId()
        );
    }

    public List<SSRDto> getSSRDtos(List<SSR> ssrs) {
        return ssrs.stream().map(this::getSSRDto).toList();
    }
}
