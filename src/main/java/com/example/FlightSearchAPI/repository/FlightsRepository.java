package com.example.FlightSearchAPI.repository;

import com.example.FlightSearchAPI.entity.FlightsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightsRepository extends JpaRepository<FlightsEntity, Long> {
}
