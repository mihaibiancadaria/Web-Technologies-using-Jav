package com.project.AirlineEticketing.controller;

import com.project.AirlineEticketing.domain.Seat;
import com.project.AirlineEticketing.dto.SeatDto;
import com.project.AirlineEticketing.dto.UpdateSeatDto;
import com.project.AirlineEticketing.mapper.SeatMapper;
import com.project.AirlineEticketing.service.SeatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/seats")
public class SeatController {
    private SeatService seatService;
    private SeatMapper seatMapper;

    public SeatController(SeatService seatService, SeatMapper SeatMapper) {
        this.seatService = seatService;
        this.seatMapper = seatMapper;
    }

    @PostMapping
    public ResponseEntity<Seat> createSeat(
            @RequestBody
            @Valid
                    SeatDto seatDto) {
        Seat savedSeat = seatService.createSeat(seatMapper.seatDtoToSeat(seatDto));
        return ResponseEntity
                .created(null)
                .body(savedSeat);
    }

    @PutMapping("/{SeatID}")
    public void updateSeat(
            @PathVariable
                    Long SeatID,
            @RequestBody
            @Valid
                    UpdateSeatDto updateSeatDto) {
        if(SeatID != updateSeatDto.getSeatID()) {
            throw new RuntimeException("Path variable doesn't match the request body id");
        }
        seatService.updateSeat(seatMapper.updateSeatDtoToSeat(updateSeatDto));
    }
}
