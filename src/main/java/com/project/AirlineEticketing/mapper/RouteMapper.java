package com.project.AirlineEticketing.mapper;

import com.project.AirlineEticketing.dto.*;
import com.project.AirlineEticketing.domain.*;
import org.springframework.stereotype.*;

@Component
public class RouteMapper {

    public Route routeDtoToRoute(RouteDto routeDto) {
        return new Route(routeDto.getDepAirport(), routeDto.getArrAirport(), routeDto.getFee());
    }

    public Route updateRouteDtoToRoute(UpdateRouteDto updateRouteDto) {
        return new Route(updateRouteDto.getRouteID(), updateRouteDto.getDepAirport(), updateRouteDto.getArrAirport(), updateRouteDto.getFee());
    }

//    @Mappings(
//            {
//                    @Mapping(target = "RouteID", source = "Routes.RouteID"),
//                    @Mapping(target = "DepAirport", source = "Routes.DepAirport"),
//                    @Mapping(target = "ArrAirport", source = "Routes.ArrAirport"),
//                    @Mapping(target = "Fee", source = "Routes.Fee")
//            }
//    )
//    RouteDto mapToDto(Route route);
//
//    @Mappings(
//            {
//                    @Mapping(target = "Routes.RouteID", source = "RouteID"),
//                    @Mapping(target = "Routes.DepAirport", source = "DepAirport"),
//                    @Mapping(target = "Routes.ArrAirport", source = "ArrAirport"),
//                    @Mapping(target = "Routes.Fee", source = "Fee")
//            }
//    )
//    Route mapToEntity(RouteDto routeDto);

}
