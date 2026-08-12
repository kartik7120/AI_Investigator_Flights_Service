package com.AI_investigator.Controllers;

import com.AI_investigator.dto.GetFlightRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FlightApi {

    @PostMapping("/getFlights")
    public String getFlights(@RequestBody GetFlightRequest getFlightRequest) {



    }
}
