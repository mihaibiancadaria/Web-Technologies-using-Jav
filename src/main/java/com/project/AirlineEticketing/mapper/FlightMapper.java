package com.project.AirlineEticketing.mapper;

import com.project.AirlineEticketing.dto.*;
import com.project.AirlineEticketing.domain.*;
import org.springframework.stereotype.*;

@Component
public class FlightMapper {


    public Flight flightDtoToFlight(FlightDto flightDto) {
        return new Flight(flightDto.getRouteID(), flightDto.getFlightCode(), flightDto.getFlightDate(), flightDto.getDepartureTime(), flightDto.getArrivalTime());
    }

    public Flight updateFlightDtoToFlight(UpdateFlightDto updateFlightDto) {
        return new Flight(updateFlightDto.getFlightID(), updateFlightDto.getRouteID(), updateFlightDto.getFlightCode(), updateFlightDto.getFlightDate(), updateFlightDto.getDepartureTime(), updateFlightDto.getArrivalTime());
    }

//    @Mappings(
//            {
//                    @Mapping(target = "FlightID", source = "Flights.FlightID"),
//                    @Mapping(target = "RouteID", source = "Flights.RouteID"),
//                    @Mapping(target = "FlightCode", source = "Flights.FlightCode"),
//                    @Mapping(target = "FlightDate", source = "Flights.FlightDate"),
//                    @Mapping(target = "DepartureTime", source = "Flights.DepartureTime"),
//                    @Mapping(target = "ArrivalTime", source = "Flights.ArrivalTime")
//            }
//    )
//    FlightDto mapToDto(Flight flight);
//
//    @Mappings(
//            {
//                    @Mapping(target = "Flights.FlightID", source = "FlightID"),
//                    @Mapping(target = "Flights.RouteID", source = "RouteID"),
//                    @Mapping(target = "Flights.FlightCode", source = "FlightCode"),
//                    @Mapping(target = "Flights.FlightDate", source = "FlightDate"),
//                    @Mapping(target = "Flights.DepartureTime", source = "DepartureTime"),
//                    @Mapping(target = "Flights.ArrivalTime", source = "ArrivalTime")
//            }
//    )
//    Flight mapToEntity(FlightDto flightDto);

}
