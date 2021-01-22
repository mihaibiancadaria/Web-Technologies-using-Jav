package com.project.AirlineEticketing.mapper;

import com.project.AirlineEticketing.dto.*;
import com.project.AirlineEticketing.domain.*;
import org.springframework.stereotype.*;

@Component
public class ReservationMapper {


    public Reservation reservationDtoToReservation(ReservationDto reservationDto) {
        return new Reservation(reservationDto.getClientID(), reservationDto.getFlightID(), reservationDto.getReservationDate());
    }

    public Reservation updateReservationDtoToReservation(UpdateReservationDto updateReservationDto) {
        return new Reservation(updateReservationDto.getReservationID(), updateReservationDto.getClientID(), updateReservationDto.getFlightID(), updateReservationDto.getReservationDate());
    }


//    @Mappings(
//            {
//                    @Mapping(target = "ReservationID", source = "Reservations.ReservationID"),
//                    @Mapping(target = "ClientID", source = "Reservations.ClientID"),
//                    @Mapping(target = "FlightID", source = "Reservations.FlightID"),
//                    @Mapping(target = "ReservationDate", source = "Reservations.ReservationDate")
//            }
//    )
//    ReservationDto mapToDto(Reservation reservation);
//
//    @Mappings(
//            {
//                    @Mapping(target = "Reservations.ReservationID", source = "ReservationID"),
//                    @Mapping(target = "Reservations.ClientID", source = "ClientID"),
//                    @Mapping(target = "Reservations.FlightID", source = "FlightID"),
//                    @Mapping(target = "Reservations.ReservationDate", source = "ReservationDate")
//            }
//    )
//    Reservation mapToEntity(ReservationDto reservationDto);

}
