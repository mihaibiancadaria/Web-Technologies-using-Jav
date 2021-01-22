package com.project.AirlineEticketing.repository;

import com.project.AirlineEticketing.domain.Airport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestParam;


public interface AirportIRepository  {

    Page<Airport> findAirportByAirportID(@RequestParam("AirportID") Long AirportID, Pageable pageable);

    Page<Airport> findAirportByAirportName(@RequestParam("AirportName") String AirportName, Pageable pageable);

}
