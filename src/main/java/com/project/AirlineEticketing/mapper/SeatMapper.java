package com.project.AirlineEticketing.mapper;

import com.project.AirlineEticketing.dto.*;
import com.project.AirlineEticketing.domain.*;
import org.springframework.stereotype.*;

@Component
public class SeatMapper {


    public Seat seatDtoToSeat(SeatDto seatDto) {
        return new Seat(seatDto.getFlightID(), seatDto.getSeatNumber());
    }

    public Seat updateSeatDtoToSeat(UpdateSeatDto updateSeatDto) {
        return new Seat(updateSeatDto.getSeatID(), updateSeatDto.getFlightID(), updateSeatDto.getSeatNumber());
    }

//    @Mappings(
//            {
//                    @Mapping(target = "SeatID", source = "Seats.SeatID"),
//                    @Mapping(target = "FlightID", source = "Seats.FlightID"),
//                    @Mapping(target = "SeatNumber", source = "Seats.SeatNumber")
//            }
//    )
//    SeatDto mapToDto(Seat seat);
//
//    @Mappings(
//            {
//                    @Mapping(target = "Seats.SeatID", source = "SeatID"),
//                    @Mapping(target = "Seats.FlightID", source = "FlightID"),
//                    @Mapping(target = "Seats.SeatNumber", source = "SeatNumber")
//            }
//    )
//    Seat mapToEntity(SeatDto seatDto);

}
