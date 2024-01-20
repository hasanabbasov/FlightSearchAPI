package com.example.FlightSearchAPI.repository;

import com.example.FlightSearchAPI.entity.FlightsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FlightsRepository extends JpaRepository<FlightsEntity, Long> {
    List<FlightsEntity> findByDepartureAirportAndArrivalAirportAndDepartureTime(
            String departureAirport, String arrivalAirport, LocalDateTime departureTime);

    List<FlightsEntity> findByDepartureAirportAndArrivalAirportAndDepartureTimeAndReturnTime(
            String departureAirport, String arrivalAirport, LocalDateTime departureTime, LocalDateTime returnTime);

}
