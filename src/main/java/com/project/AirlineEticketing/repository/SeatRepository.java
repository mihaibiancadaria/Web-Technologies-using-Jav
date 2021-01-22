package com.project.AirlineEticketing.repository;
import com.project.AirlineEticketing.domain.Route;
import com.project.AirlineEticketing.domain.Seat;
import com.project.AirlineEticketing.exception.EntityNotFoundException;
import com.project.AirlineEticketing.exception.EntityNotFoundIntegerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class SeatRepository {


    private JdbcTemplate jdbcTemplate;


    public SeatRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Seat createSeat(Seat seat) {
        String sql = "insert into seats values (null, ?, ?)";
        PreparedStatementCreator preparedStatementCreator = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, seat.getFlightID());
            preparedStatement.setString(2, seat.getSeatNumber());
            return preparedStatement;
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(preparedStatementCreator, generatedKeyHolder);


        return seat;
    }

    public Optional<Seat> getBySeatID(Long SeatID) {
        String sql = "select * from seats s where s.SeatID = ?";
        List<Seat> result = jdbcTemplate.query(sql, getSeatRowMapper(), SeatID);
        if (result != null && !result.isEmpty()) {
            return Optional.of(result.get(0));
        } else {
            return Optional.empty();
        }
    }

    public void updateSeat(Seat seat) {
        String sql = "update seats s set s.FlightID = ?, s.SeatNumber = ? where s.SeatID = ?";
        jdbcTemplate.update(sql, seat.getSeatID(), seat.getFlightID(), seat.getSeatNumber());
    }

    public boolean existsById(String SeatID) {
        String sql = "select * from seats s where s.SeatID = ?";
        List<Seat> result = jdbcTemplate.query(sql, getSeatRowMapper(), SeatID);
        if (result != null && !result.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    private RowMapper<Seat> getSeatRowMapper() {
        return (resultSet, rowNum) -> {
            Seat seat = new Seat();
            seat.setSeatID(resultSet.getLong("SeatID"));
            seat.setFlightID(resultSet.getLong("FlightID"));
            seat.setSeatNumber(resultSet.getString("SeatNmber"));
            return seat;
        };
    }




}
    //    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    public Seat save(Seat seat) {
//        String saveSeatSql = "INSERT INTO seats (SeatID, FlightID, SeatNumber) VALUES (?, ?, ?)";
//        jdbcTemplate.update(saveSeatSql, seat.getSeatID(), seat.getFlightID(), seat.getSeatNumber());
//
//        Seat savedSeat = getSeatWith(seat.getSeatID(), seat.getFlightID());
//
//
//        return savedSeat;
//    }
//
//    public List<Seat> getAll() {
//        String selectSql = "SELECT * from seats";
//
//        RowMapper<Seat> rowMapper = (resultSet, rowNo) -> Seat.builder()
//                .SeatID(resultSet.getInt("SeatID"))
//                .FlightID(resultSet.getInt("FlightID"))
//                .SeatNumber(resultSet.getString("SeatNumber"))
//                .build();
//
//        return jdbcTemplate.query(selectSql, rowMapper);
//    }
//
//    public Seat get(Integer seatID, Integer flightID) {
//        return getSeatWith(seatID, flightID);
//    }
//
//    private Seat getSeatWith(Integer SeatID, Integer FlightID) {
//        String selectSql = "SELECT * from seats WHERE seats.SeatID = ? and seats.flightID = ?";
//
//        RowMapper<Seat> rowMapper = (resultSet, rowNo) -> Seat.builder()
//                .SeatID(resultSet.getInt("SeatID"))
//                .FlightID(resultSet.getInt("FlightID"))
//                .SeatNumber(resultSet.getString("SeatNumber"))
//                .build();
//
//
//        List<Seat> seats = jdbcTemplate.query(selectSql, rowMapper, SeatID, FlightID);
//
//        if (null != seats && !seats.isEmpty()) {
//            return seats.get(0);
//        }
//        throw new EntityNotFoundIntegerException(SeatID);
//    }
//
//
//}