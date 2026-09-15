package com.AI_investigator.service;

import com.AI_investigator.Repo.SeatRepo;
import com.AI_investigator.model.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeatService {

    @Autowired
    private SeatRepo seatRepo;

    public Seat getSeatById(Integer seatId) {

        return seatRepo.findById(seatId).orElse(null);
    }
}
