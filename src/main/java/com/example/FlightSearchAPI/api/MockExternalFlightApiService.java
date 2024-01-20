package com.example.FlightSearchAPI.api;

import com.example.FlightSearchAPI.entity.FlightsEntity;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MockExternalFlightApiService {

    public List<FlightsEntity> getFlightsFromExternalApi() {
        List<FlightsEntity> flights = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            flights.add(createRandomFlight());
        }
        return flights;
    }

    private FlightsEntity createRandomFlight() {
        Random rand = new Random();
        FlightsEntity flight = new FlightsEntity();
        flight.setDepartureAirport("Havaalanı " + rand.nextInt(10));
        flight.setArrivalAirport("Havaalanı " + rand.nextInt(10));
        flight.setDepartureTime(LocalDateTime.now());
        flight.setReturnTime(LocalDateTime.now().plusDays(1));
        flight.setPrice(100.0 + rand.nextDouble() * 900);
        return flight;
    }
}
