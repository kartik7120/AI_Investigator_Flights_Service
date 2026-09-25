package com.AI_investigator.service;

import com.AI_investigator.Repo.SeatRepo;
import com.AI_investigator.model.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {

    @Autowired
    private SeatRepo seatRepo;

    public Seat getSeatById(Integer seatId) {

        return seatRepo.findById(Long.valueOf(seatId)).orElse(null);
    }

    public List<Seat> getSeatMap(int flightID) {

        return seatRepo.getSeatMapByFlightId(flightID);
    }
}
