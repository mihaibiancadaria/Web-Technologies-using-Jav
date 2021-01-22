package com.project.AirlineEticketing.service;

import com.project.AirlineEticketing.domain.Reservation;
import com.project.AirlineEticketing.exception.Duplicate;
import com.project.AirlineEticketing.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ReservationService {
    private ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation createReservation(Reservation reservation) {
        Optional<Reservation> reservationWithSameID = reservationRepository.getByReservationID(reservation.getReservationID());
        if (reservationWithSameID.isPresent()) {
            throw new Duplicate();
        }
        return reservationRepository.createReservation(reservation);
    }

    public void updateReservation(Reservation reservation) {
        reservationRepository.updateReservation(reservation);
    }
}
