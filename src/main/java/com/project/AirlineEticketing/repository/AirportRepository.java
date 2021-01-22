package com.project.AirlineEticketing.repository;
import com.project.AirlineEticketing.domain.Airport;
import lombok.extern.java.Log;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.support.*;
import org.springframework.stereotype.*;

import java.sql.*;
import java.util.*;

@Repository
public class AirportRepository {
    private JdbcTemplate jdbcTemplate;


    public AirportRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Airport createAirport(Airport airport) {
        String sql = "insert into airports  values (null, ?, ?)";
        PreparedStatementCreator preparedStatementCreator = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, airport.getAirportName());
            preparedStatement.setString(2, airport.getAirportLocation());
            return preparedStatement;
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();


        jdbcTemplate.update(preparedStatementCreator);
//        if (generatedKeyHolder.getKey() != null){
//            airport.setAirportID(generatedKeyHolder.getKey().longValue());
//        }
//        else airport.setAirportID (new Long (6));
//
//        if (airport.getAirportName() != null){
//            airport.setAirportName(airport.getAirportName());
//        }
//        else airport.setAirportName (new String("abcd"));
//

        return airport;
    }

   public Optional<Airport> getByAirportName(String AirportName) {
        String sql = "select * from airports a where a.AirportName = ?";

        RowMapper<Airport> rowMapper = (resultSet, rowNum) -> {
            Airport airport = new Airport();
            airport.setAirportID(resultSet.getLong("AirportID"));
            airport.setAirportName(resultSet.getString("AirportName"));
            airport.setAirportLocation(resultSet.getString("AirportLocation"));
            return airport;
        };
        List<Airport> result = jdbcTemplate.query(sql, rowMapper, AirportName);
        if (result != null && !result.isEmpty()) {
            return Optional.of(result.get(0));
        } else {
            return Optional.empty();
        }
    }
    private RowMapper<Airport> getAirportRowMapper() {
        return (resultSet, rowNum) -> {
            Airport airport = new Airport();
            airport.setAirportID(resultSet.getLong("AirportID"));
            airport.setAirportName(resultSet.getString("AirportName"));
            airport.setAirportLocation(resultSet.getString("AirportLocation"));
            return airport;
        };
    }


    public void updateAirport(Airport airport) {
        String sql = "update airports a set a.AirportName = ?, a.AirportLocation = ? where a.AirportID = ?";
        jdbcTemplate.update(sql, airport.getAirportID(), airport.getAirportName(), airport.getAirportLocation());
    }

    public boolean existsByAirportId(Long AirportID) {
        String sql = "select * from airports a where a.AirportID = ?";
        List<Airport> result = jdbcTemplate.query(sql, getAirportRowMapper(), AirportID);
        if (result != null && !result.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

//
//    public Airport get(String airportName) {
//        return getByAirportName(airportName);
//    }
//
//
//
//}





//    public Airport save(Airport airport) {
//        String saveAirportSql = "INSERT INTO airports (AirportID, AirportName, AirportLocation) VALUES (?, ?, ?)";
//        jdbcTemplate.update(saveAirportSql, airport.getAirportID(), airport.getAirportName(), airport.getAirportLocation());
//
//        Airport savedAirport = getAirportWith(airport.getAirportID());
//
//
//        return savedAirport;
//    }
//
//    public List<Airport> getAll() {
//        String selectSql = "SELECT * from airports";
//
//        RowMapper<Airport> rowMapper = (resultSet, rowNo) -> Airport.builder()
//                .AirportID(resultSet.getString("AirportID"))
//                .AirportName(resultSet.getString("AirportName"))
//                .AirportLocation(resultSet.getString("AirportLocation"))
//                .build();
//
//        return jdbcTemplate.query(selectSql, rowMapper);
//    }
//
//    public Airport get(String AirportID) {
//        return getAirportWith(AirportID);
//    }
//
//    private Airport getAirportWith(String AirportID) {
//        String selectSql = "SELECT * from Airports WHERE Airports.AirportID = ?";
//
//
//                .AirportID(resultSet.getString("AirportID"))
//                .AirportName(resultSet.getString("AirportName"))
//                .AirportLocation(resultSet.getString("AirportLocation"))
//                .build();
//
//        List<Airport> airports = jdbcTemplate.query(selectSql, rowMapper, AirportID);
//
//        if (null != airports && !airports.isEmpty()) {
//            return airports.get(0);
//        }
//        throw new EntityNotFoundException(AirportID);
//    }
//


}