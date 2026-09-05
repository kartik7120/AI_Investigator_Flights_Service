package com.AI_investigator.Repo;

import com.AI_investigator.dto.GetFlightRequest;
import com.AI_investigator.dto.enums.DepartureSectorEnum;
import com.AI_investigator.dto.enums.DestinationSectorEnum;
import com.AI_investigator.dto.enums.FareType;
import com.AI_investigator.model.Flight;
import com.AI_investigator.model.SSR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FlightRepo extends JpaRepository<Flight, Integer> {

    @Query("SELECT f FROM Flight f WHERE f.departureSector = :departureSector AND f.destinationSector = :destinationSector AND f.departureTime >= :startDate AND f.departureTime <= :endDate")
    List<Flight> getFlights(
            @Param("departureSector") DepartureSectorEnum departureSector,
            @Param("destinationSector") DestinationSectorEnum destinationSector,
            @Param("startDate") LocalDateTime departureDate,
            @Param("endDate") LocalDateTime nextDate
    );

    List<SSR> findByFlightIdAndFareType(Long flightId, FareType fareType);

//    @Query("SELECT f FROM Flight f WHERE f.")
//    List<Flight> getFlightOneWay(
//            @Param("departureSector") DepartureSectorEnum departureSector,
//            @Param("destinationSector") DestinationSectorEnum destinationSector,
//            @Param("startDate") LocalDateTime departureDate
//    );
}
