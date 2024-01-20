package com.example.FlightSearchAPI.service;

import com.example.FlightSearchAPI.entity.AirportEntity;
import com.example.FlightSearchAPI.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirportService {

    private final AirportRepository airportRepository;

    @Autowired
    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public AirportEntity createAirport(AirportEntity airport) {
        return airportRepository.save(airport);
    }

    public List<AirportEntity> getAllAirports() {
        return airportRepository.findAll();
    }

    public Optional<AirportEntity> getAirportById(Long id) {
        return airportRepository.findById(id);
    }

    public Optional<AirportEntity> updateAirport(Long id, AirportEntity newAirport) {
        return airportRepository.findById(id)
                .map(airport -> {
                    airport.setCity(newAirport.getCity());
                    return airportRepository.save(airport);
                });
    }

    public boolean deleteAirport(Long id) {
        if (airportRepository.existsById(id)) {
            airportRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
