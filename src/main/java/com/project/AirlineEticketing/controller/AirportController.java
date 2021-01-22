package com.project.AirlineEticketing.controller;

import com.project.AirlineEticketing.dto.*;
import com.project.AirlineEticketing.mapper.*;
import com.project.AirlineEticketing.domain.*;
import com.project.AirlineEticketing.service.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;

@RestController
@RequestMapping("/airports")
public class AirportController {
    private  AirportService airportService;
    private  AirportMapper airportMapper;

    public AirportController(AirportService airportService, AirportMapper airportMapper) {
        this.airportService = airportService;
        this.airportMapper = airportMapper;
    }

    @PostMapping
    public ResponseEntity<Airport> createAirport(
            @RequestBody
            @Valid
                    AirportDto airportDto) {
        Airport savedAirport = airportService.createAirport(airportMapper.airportDtoToAirport(airportDto));
        return ResponseEntity
                .created(null)
                .body(savedAirport);
    }

    @PutMapping("/{AirportID}")
    public void updateAirport(
            @PathVariable
                    Long AirportID,
            @RequestBody
            @Valid
                    UpdateAirportDto updateAirportDto) {
        if(AirportID != updateAirportDto.getAirportID()) {
            throw new RuntimeException("Path variable doesn't match the request body id");
        }
        airportService.updateAirport(airportMapper.updateAirportDtoToAirport(updateAirportDto));
    }

//    @GetMapping("/{AirportID}")
//    public ResponseEntity<AirportDto> get(@PathVariable("AirportID") Long AirportID) {
//        AirportDto airportDto = airportService.getOne(AirportID);
//
//        return ResponseEntity
//                .ok()
//                .body(airportDto);
//    }

}

