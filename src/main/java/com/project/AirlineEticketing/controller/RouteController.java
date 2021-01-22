package com.project.AirlineEticketing.controller;

import com.project.AirlineEticketing.domain.Route;
import com.project.AirlineEticketing.dto.RouteDto;
import com.project.AirlineEticketing.dto.UpdateRouteDto;
import com.project.AirlineEticketing.mapper.RouteMapper;
import com.project.AirlineEticketing.service.RouteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

    @RestController
    @RequestMapping("/routes")
    public class RouteController {
        private RouteService routeService;
        private RouteMapper routeMapper;

        public RouteController(RouteService routeService, RouteMapper routeMapper) {
            this.routeService = routeService;
            this.routeMapper = routeMapper;
        }

        @PostMapping
        public ResponseEntity<Route> createRoute(
                @RequestBody
                @Valid
                        RouteDto routeDto) {
            Route savedRoute = routeService.createRoute(routeMapper.routeDtoToRoute(routeDto));
            return ResponseEntity
                    .created(null)
                    .body(savedRoute);
        }

        @PutMapping("/{RouteID}")
        public void updateRoute(
                @PathVariable
                        Long RouteID,
                @RequestBody
                @Valid
                        UpdateRouteDto updateRouteDto) {
            if(RouteID != updateRouteDto.getRouteID()) {
                throw new RuntimeException("Path variable doesn't match the request body id");
            }
            routeService.updateRoute(routeMapper.updateRouteDtoToRoute(updateRouteDto));
        }
    }
