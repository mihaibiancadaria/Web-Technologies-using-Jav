package com.project.AirlineEticketing;

import com.project.AirlineEticketing.exception.*;
import com.project.AirlineEticketing.domain.*;
import com.project.AirlineEticketing.service.*;
import com.project.AirlineEticketing.repository.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.mockito.*;
import org.mockito.junit.jupiter.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AirportServiceTest {
    @Mock
    private AirportRepository airportRepository;
    @InjectMocks
    private AirportService airportService;

    @Test
    @DisplayName("Create airport")
    void createAirport() {
        Airport airport = new Airport( "IAS", "Iasi");
        Airport savedAirport = new Airport(1L,"IAS", "Iasi");
        when(airportRepository.getByAirportName(any())).thenReturn(Optional.empty());
        when(airportRepository.createAirport(any())).thenReturn(savedAirport);

        Airport result = airportService.createAirport(airport);

        assertEquals(airport.getAirportName(), result.getAirportName());
        assertEquals(airport.getAirportLocation(), result.getAirportLocation());
        assertEquals(1, result.getAirportID());

        verify(airportRepository).getByAirportName(any());
        verify(airportRepository).createAirport(any());
    }

    @Test
    @DisplayName("Create airport - airport with same name already exists")
    void createAirportThrowsException() {
        Airport airport = new Airport( "IAS", "Iasi");
        Airport savedAirport = new Airport(1L,"IAS", "Iasi");
        when(airportRepository.getByAirportName(any())).thenReturn(Optional.of(savedAirport));

        Duplicate exception = assertThrows(Duplicate.class,
                () -> airportService.createAirport(airport));

        assertEquals("An airport with the same name already exists.",
                exception.getMessage());

        verify(airportRepository).getByAirportName(any());
        verify(airportRepository, times(0)).createAirport(any());
    }
}