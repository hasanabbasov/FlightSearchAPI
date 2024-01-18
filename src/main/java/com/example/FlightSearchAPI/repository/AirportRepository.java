package com.example.FlightSearchAPI.repository;

import com.example.FlightSearchAPI.entity.AirportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<AirportEntity, Long> {

}
