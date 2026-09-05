package com.AI_investigator.seeder;


import com.AI_investigator.dto.enums.*;
import com.AI_investigator.model.*;
import com.AI_investigator.utils.GenerateSSR;
import net.datafaker.Faker;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Service
public class FlightDataSeeder {

    public record FlightRoute(
            DepartureSectorEnum departure,
            DestinationSectorEnum destination
    ) {
    }

    private final Faker faker = new Faker();

    @Autowired
    private GenerateSSR ssrGenerator;

    public List<Flight> generateFakeFlights() {
        List<Flight> flights = new ArrayList<>();

//        Generate 150 flights

        for (int i = 0; i < 50; i++) {
            Flight flight = new Flight();

            FlightRoute r = faker.options().option(FlightRoutes.ROUTES.toArray(new FlightRoute[0]));

            List<SSR> economySSRs = ssrGenerator.createDefaultSSRs(flight);
            List<SSR> premiumSSRs = ssrGenerator.createPremiumSSRs(flight);
            List<SSR> businessSSRs = ssrGenerator.createBusinessSSRs(flight);

            DepartureSectorEnum departure = r.departure();
            DestinationSectorEnum destination = r.destination();

            flight.setDestinationSector(destination);
            flight.setDepartureSector(departure);

            Instant from = Instant.now();
            Instant to = from.plus(Duration.ofDays(30));

            Instant departureInstant = faker.timeAndDate().between(from, to);

            LocalDateTime departureTime = LocalDateTime.ofInstant(
                    departureInstant,
                    ZoneId.systemDefault()
            );

            flight.setDepartureTime(departureTime);

            Instant arrivalInstant = departureInstant.plus(
                    Duration.ofMinutes(
                            faker.number().numberBetween(90, 600)
                    )
            );

            LocalDateTime arrivalTime = LocalDateTime.ofInstant(
                    arrivalInstant,
                    ZoneId.systemDefault()
            );

            flight.setArrivalTime(arrivalTime);

            String route = departure.toString() + "-" + destination.toString();

            String flightNumber = String.format(
                    "FK%04d",
                    faker.number().numberBetween(1, 9999)
            );

            flight.setFlightNumber(flightNumber);

            List<Price> priceList = new ArrayList<>();

            Price saverPrice = new Price();

            saverPrice.setBasePrice(
                    BigDecimal.valueOf(faker.number().numberBetween(3000, 6000))
            );

            saverPrice.setCurrentPrice(BigDecimal.valueOf(faker.number().numberBetween(3000, 6000)));

            saverPrice.setFareType(FareType.ECONOMY);

            Price preminumEconomyPrice = new Price();

            preminumEconomyPrice.setFareType(FareType.PREMIUM_ECONOMY);
            preminumEconomyPrice.setBasePrice(BigDecimal.valueOf(faker.number().numberBetween(6001, 15000)));
            preminumEconomyPrice.setCurrentPrice(BigDecimal.valueOf(faker.number().numberBetween(6001, 15000)));

            Price businessPrice = new Price();

            businessPrice.setFareType(FareType.BUSINESS);
            businessPrice.setBasePrice(BigDecimal.valueOf(faker.number().numberBetween(15001, 30000)));
            businessPrice.setCurrentPrice(BigDecimal.valueOf(faker.number().numberBetween(15001, 30000)));

            priceList.add(saverPrice);
            priceList.add(preminumEconomyPrice);
            priceList.add(businessPrice);

            flight.setBasePrice(priceList);

            BaggageAllowance[] baggageAllowances = getBaggageAllowances(departure);

            flight.setBaggageAllowance(baggageAllowances);

            List<Seat> seats = this.generateSeatMap(flight, 5);

            flight.setSeatMap(seats);

            List<SSR> allSSRs = new ArrayList<>();

            allSSRs.addAll(economySSRs);
            allSSRs.addAll(premiumSSRs);
            allSSRs.addAll(businessSSRs);

            flight.setSsrList(allSSRs);
            flights.add(flight);
        }

        System.out.println("Flights = " + flights);

        return flights;
    }

    private static BaggageAllowance @NonNull [] getBaggageAllowances(DepartureSectorEnum departure) {
        BaggageAllowance[] baggageAllowances;

        if (departure.isInternational()) {
            baggageAllowances = new BaggageAllowance[]{
                    BaggageAllowance.INTERNATIONAL_ECONOMY,
                    BaggageAllowance.INTERNATIONAL_PREMIUM_ECONOMY,
                    BaggageAllowance.INTERNATIONAL_BUSINESS
            };
        } else {
            baggageAllowances = new BaggageAllowance[]{
                    BaggageAllowance.DOMESTIC_ECONOMY,
                    BaggageAllowance.DOMESTIC_PREMIUM_ECONOMY,
                    BaggageAllowance.DOMESTIC_BUSINESS
            };
        }
        return baggageAllowances;
    }

    private List<Seat> generateSeatMap(
            Flight flight,
            int rows
    ) {
        List<Seat> seats = new ArrayList<>();

        String[] columns = {"A", "B", "C", "D", "E", "F"};

        for (int row = 1; row <= rows; row++) {

            for (int column = 0; column < columns.length; column++) {

                Seat seat = new Seat();

                seat.setSeatNumber(row + columns[column]);
                seat.setSeatRow(row);
                seat.setSeatColumn(column + 1);
                seat.setFlight(flight);

                seat.setStatus(SeatStatus.AVAILABLE);

                // First few rows → Business
                if (row <= 3) {
                    seat.setSeatClass(SeatClass.BUSINESS);
                }
                // Next few rows → Premium Economy
                else if (row <= 8) {
                    seat.setSeatClass(SeatClass.PREMIUM_ECONOMY);
                }
                // Remaining → Economy
                else {
                    seat.setSeatClass(SeatClass.ECONOMY);
                }

                seats.add(seat);
            }
        }

        return seats;
    }
}
