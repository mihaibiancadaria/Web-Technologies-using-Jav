package com.project.AirlineEticketing.service;

import com.project.AirlineEticketing.domain.Route;
import com.project.AirlineEticketing.exception.Duplicate;
import com.project.AirlineEticketing.repository.RouteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class RouteService {
    private RouteRepository routeRepository;

    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public Route createRoute(Route route) {
        Optional<Route> routeWithSameID = routeRepository.getByRouteID(route.getRouteID());
        if (routeWithSameID.isPresent()) {
            throw new Duplicate();
        }
        return routeRepository.createRoute(route);
    }

    public void updateRoute(Route route) {
        routeRepository.updateRoute(route);
    }
}