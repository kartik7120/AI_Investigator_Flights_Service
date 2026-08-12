package com.AI_investigator.dto;

import com.AI_investigator.dto.enums.DepartureSectorEnum;
import com.AI_investigator.dto.enums.DestinationSectorEnum;
import com.AI_investigator.dto.enums.PromoCode;

public class GetFlightRequest {

    public DestinationSectorEnum destination_sector;
    public DepartureSectorEnum departure_sector;
    public String departure_date;
    public String return_date;
    public PromoCode promo_code;
}
