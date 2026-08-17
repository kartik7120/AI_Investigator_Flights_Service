package com.AI_investigator.Repo;

import com.AI_investigator.model.Flight;
import com.AI_investigator.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepo extends JpaRepository<Flight, Integer> {

}
