package com.project.AirlineEticketing.repository;

import com.project.AirlineEticketing.domain.Route;
import com.project.AirlineEticketing.domain.Airport;
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
public class RouteRepository {


    private JdbcTemplate jdbcTemplate;


    public RouteRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Route createRoute(Route route) {
        String sql = "insert into routes values (null, ?, ?, ?)";
        PreparedStatementCreator preparedStatementCreator = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, route.getDepAirport());
            preparedStatement.setLong(2, route.getArrAirport());
            preparedStatement.setInt(3, route.getFee());
            return preparedStatement;
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(preparedStatementCreator, generatedKeyHolder);


        return route;
    }

    public Optional<Route> getByRouteID(Long RouteID) {
        String sql = "select * from routes r where r.RouteID = ?";
        List<Route> result = jdbcTemplate.query(sql, getRouteRowMapper(), RouteID);
        if (result != null && !result.isEmpty()) {
            return Optional.of(result.get(0));
        } else {
            return Optional.empty();
        }
    }

    public void updateRoute(Route route) {
        String sql = "update routes r set r.DepAirport = ?, r.ArrAirport = ?, r.Fee = ? where r.RouteID = ?";
        jdbcTemplate.update(sql, route.getRouteID(), route.getDepAirport(), route.getArrAirport(), route.getFee());
    }

    public boolean existsById(String RouteID) {
        String sql = "select * from routes r where r.RouteID = ?";
        List<Route> result = jdbcTemplate.query(sql, getRouteRowMapper(), RouteID);
        if (result != null && !result.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    private RowMapper<Route> getRouteRowMapper() {
        return (resultSet, rowNum) -> {
            Route route = new Route();
            route.setRouteID(resultSet.getLong("RouteID"));
            route.setDepAirport(resultSet.getLong("DepAirport"));
            route.setArrAirport(resultSet.getLong("ArrAirport"));
            route.setFee(resultSet.getInt("Fee"));
            return route;
        };
    }




//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    public Route save(Route route) {
//        String saveRouteSql = "INSERT INTO routes (DepAirport, ArrAirport, Fee) VALUES (?, ?, ?)";
//        jdbcTemplate.update(saveRouteSql, route.getDepAirport(), route.getArrAirport(), route.getFee());
//
//        Route savedRoute = getRouteWith(route.getRouteID());
//
//
//        return savedRoute;
//    }
//
//    public List<Route> getAll() {
//        String selectSql = "SELECT * from routes";
//
//        RowMapper<Route> rowMapper = (resultSet, rowNo) -> Route.builder()
//                .RouteID(resultSet.getInt("RouteID"))
//                .DepAirport(resultSet.getString("DepAirport"))
//                .ArrAirport(resultSet.getString("ArrAirport"))
//                .Fee(resultSet.getInt("Fee"))
//                .build();
//
//        return jdbcTemplate.query(selectSql, rowMapper);
//    }
//
//    public Route get(Integer routeID) {
//        return getRouteWith(routeID);
//    }
//
//    private Route getRouteWith(Integer RouteID) {
//        String selectSql = "SELECT * from routes WHERE routes.RouteID = ?";
//
//        RowMapper<Route> rowMapper = (resultSet, rowNo) -> Route.builder()
//                .RouteID(resultSet.getInt("RouteID"))
//                .DepAirport(resultSet.getString("DepAirport"))
//                .ArrAirport(resultSet.getString("ArrAirport"))
//                .Fee(resultSet.getInt("Fee"))
//                .build();
//
//        List<Route> routes = jdbcTemplate.query(selectSql, rowMapper, RouteID);
//
//        if (null != routes && !routes.isEmpty()) {
//            return routes.get(0);
//        }
//        throw new EntityNotFoundIntegerException(RouteID);
//    }


}
