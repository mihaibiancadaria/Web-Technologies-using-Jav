package com.project.AirlineEticketing.repository;
import com.project.AirlineEticketing.domain.Client;
import com.project.AirlineEticketing.domain.Flight;
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

public class FlightRepository {



    private JdbcTemplate jdbcTemplate;


    public FlightRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Flight createFlight(Flight flight) {
        String sql = "insert into flights values (null, ?, ?, ?, ?, ?)";
        PreparedStatementCreator preparedStatementCreator = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, flight.getRouteID());
            preparedStatement.setString(2, flight.getFlightCode());
            preparedStatement.setDate(3, (Date) flight.getFlightDate());
            preparedStatement.setTimestamp(4, flight.getDepartureTime());
            preparedStatement.setTimestamp(5, flight.getArrivalTime());
            return preparedStatement;
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(preparedStatementCreator, generatedKeyHolder);


        return flight;
    }

    public Optional<Flight> getByFlightID(Long FlightID) {
        String sql = "select * from flights f where f.FlightID = ?";
        List<Flight> result = jdbcTemplate.query(sql, getFlightRowMapper(), FlightID);
        if (result != null && !result.isEmpty()) {
            return Optional.of(result.get(0));
        } else {
            return Optional.empty();
        }
    }

    public void updateFlight(Flight flight) {
        String sql = "update flights f set f.RouteID = ?, f.FlightCode = ?, f.FlighDate = ?, f.DepartureTime = ?, f.ArrivalTime = ? where f.FlightID = ?";
        jdbcTemplate.update(sql, flight.getFlightID(), flight.getRouteID(), flight.getFlightCode(), flight.getFlightDate(), flight.getDepartureTime(), flight.getArrivalTime());
    }

    public boolean existsById(Long FlightID) {
        String sql = "select * from flights f where f.FlightID = ?";
        List<Flight> result = jdbcTemplate.query(sql, getFlightRowMapper(), FlightID);
        if (result != null && !result.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    private RowMapper<Flight> getFlightRowMapper() {
        return (resultSet, rowNum) -> {
            Flight flight = new Flight();
            flight.setRouteID(resultSet.getLong("RouteID"));
            flight.setFlightCode(resultSet.getString("FlightCode"));
            flight.setFlightDate(resultSet.getDate("FlightDate"));
            flight.setDepartureTime(resultSet.getTimestamp("DepartureTime"));
            flight.setArrivalTime(resultSet.getTimestamp("ArrivalTime"));
            return flight;
        };
    }


//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    public Flight save(Flight flight) {
//        String saveFlightSql = "INSERT INTO flights (RouteID, FlightCode, FlightDate, DepartureTime, ArrivalTime) VALUES (?, ?, ?, ?, ?)";
//        jdbcTemplate.update(saveFlightSql, flight.getRouteID(), flight.getFlightCode(), flight.getFlightDate(), flight.getDepartureTime(), flight.getArrivalTime());
//
//        Flight savedFlight = getFlightWith(flight.getFlightID());
//
//
//        return savedFlight;
//    }
//
//    public List<Flight> getAll() {
//        String selectSql = "SELECT * from flights";
//
//        RowMapper<Flight> rowMapper = (resultSet, rowNo) -> Flight.builder()
//                .FlightID(resultSet.getInt("FlightID"))
//                .RouteID(resultSet.getInt("RouteID"))
//                .FlightCode(resultSet.getString("FlightCode"))
//                .FlightDate(resultSet.getDate("FlightDate"))
//                .DepartureTime(resultSet.getTimestamp("DepartureTime"))
//                .ArrivalTime(resultSet.getTimestamp("ArrivalTime"))
//                .build();
//
//        return jdbcTemplate.query(selectSql, rowMapper);
//    }
//
//    public Flight get(Integer flightID) {
//        return getFlightWith(flightID);
//    }
//
//    private Flight getFlightWith(Integer FlightID) {
//        String selectSql = "SELECT * from flights WHERE flights.FlightID = ?";
//
//        RowMapper<Flight> rowMapper = (resultSet, rowNo) -> Flight.builder()
//                .FlightID(resultSet.getInt("FlightID"))
//                .RouteID(resultSet.getInt("RouteID"))
//                .FlightCode(resultSet.getString("FlightCode"))
//                .FlightDate(resultSet.getDate("FlightDate"))
//                .DepartureTime(resultSet.getTimestamp("DepartureTime"))
//                .ArrivalTime(resultSet.getTimestamp("ArrivalTime"))
//                .build();
//
//        List<Flight> flights = jdbcTemplate.query(selectSql, rowMapper, FlightID);
//
//        if (null != flights && !flights.isEmpty()) {
//            return flights.get(0);
//        }
//        throw new EntityNotFoundIntegerException(FlightID);
//    }
//
}
