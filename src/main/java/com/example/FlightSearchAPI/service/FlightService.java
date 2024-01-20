package com.example.FlightSearchAPI.service;

import com.example.FlightSearchAPI.entity.FlightsEntity;
import com.example.FlightSearchAPI.repository.FlightsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    private final FlightsRepository flightRepository;

    @Autowired
    public FlightService(FlightsRepository flightRepository) {
        this.flightRepository = flightRepository;
    }


    public List<FlightsEntity> searchFlights(String departureAirport, String arrivalAirport, LocalDateTime departureTime, Optional<LocalDateTime> returnTime) {
        if (returnTime.isPresent()) {
            return flightRepository.findByDepartureAirportAndArrivalAirportAndDepartureTimeAndReturnTime(departureAirport, arrivalAirport, departureTime, returnTime.get());
        } else {
            return flightRepository.findByDepartureAirportAndArrivalAirportAndDepartureTime(departureAirport, arrivalAirport, departureTime);
        }
    }

}
