package com.project.AirlineEticketing.mapper;


import com.project.AirlineEticketing.dto.*;
import com.project.AirlineEticketing.domain.*;
import org.springframework.stereotype.*;

@Component
public class AirportMapper {


    public Airport airportDtoToAirport(AirportDto airportDto) {
        return new Airport(airportDto.getAirportName(), airportDto.getAirportLocation());
    }

    public Airport updateAirportDtoToAirport(UpdateAirportDto updateAirportDto) {
        return new Airport(updateAirportDto.getAirportID(), updateAirportDto.getAirportName(), updateAirportDto.getAirportLocation());
    }



}
