package com.AI_investigator.Repo;

import com.AI_investigator.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SeatRepo extends JpaRepository<Seat, Long> {

    @Query("SELECT s FROM Seat s WHERE s.flight.id = :flightId")
    List<Seat> getSeatMapByFlightId(@Param("flightId") int flightId);
}
