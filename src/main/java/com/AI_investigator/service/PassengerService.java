package com.AI_investigator.service;

import com.AI_investigator.Repo.PassengerRepo;
import com.AI_investigator.model.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepo passengerRepo;

    public void savePassenger(Passenger passenger) {
        passengerRepo.save(passenger);
    }
}
