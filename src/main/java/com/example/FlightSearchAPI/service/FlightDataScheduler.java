package com.example.FlightSearchAPI.service;

import com.example.FlightSearchAPI.api.MockExternalFlightApiService;
import com.example.FlightSearchAPI.entity.FlightsEntity;
import com.example.FlightSearchAPI.repository.FlightsRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FlightDataScheduler {

    private final MockExternalFlightApiService mockExternalFlightApiService;
    private final FlightsRepository flightsRepository;

    public FlightDataScheduler(MockExternalFlightApiService mockExternalFlightApiService, FlightsRepository flightsRepository) {
        this.mockExternalFlightApiService = mockExternalFlightApiService;
        this.flightsRepository = flightsRepository;
    }

    @Scheduled(cron = "0 0 1 * * *") // Her gün saat 01:00'de çalışır
    public void fetchAndStoreFlightData() {
        List<FlightsEntity> flights = mockExternalFlightApiService.getFlightsFromExternalApi();
        flightsRepository.saveAll(flights);
    }
}
