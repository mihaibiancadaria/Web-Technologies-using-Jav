package com.project.AirlineEticketing.service;

import com.project.AirlineEticketing.domain.Flight;
import com.project.AirlineEticketing.exception.Duplicate;
import com.project.AirlineEticketing.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class FlightService {
    private FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public Flight createFlight(Flight flight) {
        Optional<Flight> flightWithSameID = flightRepository.getByFlightID(flight.getFlightID());
        if (flightWithSameID.isPresent()) {
            throw new Duplicate();
        }
        return flightRepository.createFlight(flight);
    }

    public void updateFlight(Flight flight) {
        flightRepository.updateFlight(flight);
    }
}