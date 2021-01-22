package com.project.AirlineEticketing.controller;

import com.project.AirlineEticketing.domain.Flight;
import com.project.AirlineEticketing.dto.FlightDto;
import com.project.AirlineEticketing.dto.UpdateFlightDto;
import com.project.AirlineEticketing.mapper.FlightMapper;
import com.project.AirlineEticketing.service.FlightService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/flights")
public class FlightController {
    private FlightService flightService;
    private FlightMapper flightMapper;

    public FlightController(FlightService flightService, FlightMapper flightMapper) {
        this.flightService = flightService;
        this.flightMapper = flightMapper;
    }

    @PostMapping
    public ResponseEntity<Flight> createFlight(
            @RequestBody
            @Valid
                    FlightDto flightDto) {
        Flight savedFlight = flightService.createFlight(flightMapper.flightDtoToFlight(flightDto));
        return ResponseEntity
                .created(null)
                .body(savedFlight);
    }

    @PutMapping("/{FlightID}")
    public void updateFlight(
            @PathVariable
                    Long FlightID,
            @RequestBody
            @Valid
                    UpdateFlightDto updateFlightDto) {
        if(FlightID != updateFlightDto.getFlightID()) {
            throw new RuntimeException("Path variable doesn't match the request body id");
        }
        flightService.updateFlight(flightMapper.updateFlightDtoToFlight(updateFlightDto));
    }
}
