package com.project.AirlineEticketing.controller;


import com.project.AirlineEticketing.domain.Reservation;
import com.project.AirlineEticketing.dto.ReservationDto;
import com.project.AirlineEticketing.dto.UpdateReservationDto;
import com.project.AirlineEticketing.mapper.ReservationMapper;
import com.project.AirlineEticketing.service.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    private ReservationService reservationService;
    private ReservationMapper reservationMapper;

    public ReservationController(ReservationService reservationService, ReservationMapper reservationMapper) {
        this.reservationService = reservationService;
        this.reservationMapper = reservationMapper;
    }

    @PostMapping
    public ResponseEntity<Reservation> createReservation(
            @RequestBody
            @Valid
                    ReservationDto reservationDto) {
        Reservation savedReservation = reservationService.createReservation(reservationMapper.reservationDtoToReservation(reservationDto));
        return ResponseEntity
                .created(null)
                .body(savedReservation);
    }

    @PutMapping("/{ReservationID}")
    public void updateReservation(
            @PathVariable
                    Long ReservationID,
            @RequestBody
            @Valid
                    UpdateReservationDto updateReservationDto) {
        if(ReservationID != updateReservationDto.getReservationID()) {
            throw new RuntimeException("Path variable doesn't match the request body id");
        }
        reservationService.updateReservation(reservationMapper.updateReservationDtoToReservation(updateReservationDto));
    }
}
