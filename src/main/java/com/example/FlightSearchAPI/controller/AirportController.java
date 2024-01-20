package com.example.FlightSearchAPI.controller;

import com.example.FlightSearchAPI.entity.AirportEntity;
import com.example.FlightSearchAPI.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airports")
public class AirportController {

    private final AirportService airportService;

    @Autowired
    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @PostMapping
    public ResponseEntity<AirportEntity> createAirport(@RequestBody AirportEntity airport) {
        return new ResponseEntity<>(airportService.createAirport(airport), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AirportEntity>> getAllAirports() {
        return ResponseEntity.ok(airportService.getAllAirports());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AirportEntity> getAirportById(@PathVariable Long id) {
        return airportService.getAirportById(id)
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AirportEntity> updateAirport(@PathVariable Long id, @RequestBody AirportEntity airport) {
        return airportService.updateAirport(id, airport)
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteAirport(@PathVariable Long id) {
        if (airportService.deleteAirport(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
