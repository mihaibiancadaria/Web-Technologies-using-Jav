package com.project.AirlineEticketing.service;

import com.project.AirlineEticketing.domain.Airport;
import com.project.AirlineEticketing.domain.Client;
import com.project.AirlineEticketing.dto.AirportDto;
import com.project.AirlineEticketing.exception.Duplicate;
import com.project.AirlineEticketing.mapper.AirportMapper;
import com.project.AirlineEticketing.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AirportService {

    private AirportRepository airportRepository;

    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public Airport createAirport(Airport airport) {
        Optional<Airport> airportWithSameName = airportRepository.getByAirportName(airport.getAirportName());
        if (airportWithSameName.isPresent()) {
            throw new Duplicate();
        }
        return airportRepository.createAirport(airport);
    }

    public void updateAirport(Airport airport) {
        airportRepository.updateAirport(airport);
    }


//    @Autowired
//    private AirportMapper airportMapper;
//
//    public AirportDto getOne(String AirportID) {
//        Airport airport = airportRepository.get(AirportID);
//
//        return airportMapper.mapToDto(airport);
//    }




//    @Autowired
//    private AirportMapper airportMapper;
//
//    @Autowired
//    private AirportRepository airportRepository;
//
//    public AirportDto create(AirportDto airportDto) {
//        Airport airport = airportMapper.mapToEntity(airportDto);
//
//        Airport savedAirport = airportRepository.save(airport);
//        return airportMapper.mapToDto(savedAirport);
//    }
//
//    public AirportDto getOne(String airportID) {
//        Airport airport = airportRepository.get(airportID);
//
//        return airportMapper.mapToDto(airport);
//    }

}
