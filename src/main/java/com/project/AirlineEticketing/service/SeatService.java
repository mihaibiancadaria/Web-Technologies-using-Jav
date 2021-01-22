package com.project.AirlineEticketing.service;

import com.project.AirlineEticketing.domain.Seat;
import com.project.AirlineEticketing.exception.Duplicate;
import com.project.AirlineEticketing.repository.SeatRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class SeatService {
    private SeatRepository seatRepository;

    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public Seat createSeat(Seat seat) {
        Optional<Seat> seatWithSameID = seatRepository.getBySeatID(seat.getSeatID());
        if (seatWithSameID.isPresent()) {
            throw new Duplicate();
        }
        return seatRepository.createSeat(seat);
    }

    public void updateSeat(Seat seat) {
        seatRepository.updateSeat(seat);
    }
}