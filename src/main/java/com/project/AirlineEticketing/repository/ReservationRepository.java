package com.project.AirlineEticketing.repository;
import com.project.AirlineEticketing.domain.Flight;
import com.project.AirlineEticketing.domain.Reservation;
import com.project.AirlineEticketing.exception.EntityNotFoundException;
import com.project.AirlineEticketing.exception.EntityNotFoundIntegerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {



    private JdbcTemplate jdbcTemplate;


    public ReservationRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Reservation createReservation(Reservation reservation) {
        String sql = "insert into flights values (null, ?, ?, ?, ?, ?)";
        PreparedStatementCreator preparedStatementCreator = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, reservation.getClientID());
            preparedStatement.setLong(2, reservation.getFlightID());
            preparedStatement.setDate(3, (Date) reservation.getReservationDate());
            return preparedStatement;
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(preparedStatementCreator, generatedKeyHolder);


        return reservation;
    }

    public Optional<Reservation> getByReservationID(Long ReservationID) {
        String sql = "select * from reservations r where r.ReservationID = ?";
        List<Reservation> result = jdbcTemplate.query(sql, getReservationRowMapper(), ReservationID);
        if (result != null && !result.isEmpty()) {
            return Optional.of(result.get(0));
        } else {
            return Optional.empty();
        }
    }

    public void updateReservation(Reservation reservation) {
        String sql = "update reservations r set r.ClientID = ?, r.FlightID = ?, r.ReservationDate = ? where r.FlightID = ?";
        jdbcTemplate.update(sql, reservation.getReservationID(), reservation.getClientID(), reservation.getFlightID(), reservation.getReservationDate());
    }

    public boolean existsById(Long ReservationID) {
        String sql = "select * from reservations r where r.ReservationID = ?";
        List<Reservation> result = jdbcTemplate.query(sql, getReservationRowMapper(), ReservationID);
        if (result != null && !result.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    private RowMapper<Reservation> getReservationRowMapper() {
        return (resultSet, rowNum) -> {
            Reservation reservation = new Reservation();
            reservation.setClientID(resultSet.getLong("ClientID"));
            reservation.setFlightID(resultSet.getLong("FlightID"));
            reservation.setReservationDate(resultSet.getDate("ReservationDate"));
            return reservation;
        };
    }



//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    public Reservation save(Reservation reservation) {
//        String saveReservationSql = "INSERT INTO reservations (ClientID, FlightID, ReservationDate) VALUES (?, ?, ?)";
//        jdbcTemplate.update(saveReservationSql, reservation.getClientID(), reservation.getFlightID(), reservation.getReservationDate());
//
//        Reservation savedReservation = getReservationWith(reservation.getReservationID());
//
//
//        return savedReservation;
//    }
//
//    public List<Reservation> getAll() {
//        String selectSql = "SELECT * from resevations";
//
//        RowMapper<Reservation> rowMapper = (resultSet, rowNo) -> Reservation.builder()
//                .ClientID(resultSet.getInt("ClientID"))
//                .FlightID(resultSet.getInt("FlightID"))
//                .ReservationDate(resultSet.getDate("ReservationDate"))
//                .build();
//
//        return jdbcTemplate.query(selectSql, rowMapper);
//    }
//
//    public Reservation get(Integer reservationID) {
//        return getReservationWith(reservationID);
//    }
//
//    private Reservation getReservationWith(Integer ReservationID) {
//        String selectSql = "SELECT * from rservations WHERE reservations.ReservationID = ?";
//
//        RowMapper<Reservation> rowMapper = (resultSet, rowNo) -> Reservation.builder()
//                .ClientID(resultSet.getInt("ClientID"))
//                .FlightID(resultSet.getInt("FlightID"))
//                .ReservationDate(resultSet.getDate("ReservationDate"))
//                .build();
//
//
//        List<Reservation> reservations = jdbcTemplate.query(selectSql, rowMapper, ReservationID);
//
//        if (null != reservations && !reservations.isEmpty()) {
//            return reservations.get(0);
//        }
//        throw new EntityNotFoundIntegerException(ReservationID);
//    }


}
