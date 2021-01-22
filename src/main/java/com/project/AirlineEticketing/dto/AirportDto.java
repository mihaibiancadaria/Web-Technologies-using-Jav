package com.project.AirlineEticketing.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AirportDto {


    @NotNull
    @Size(max = 100)
    private String AirportName;
    private String AirportLocation;

    public AirportDto(){

    }

    public AirportDto(String AirportName, String AirportLocation){
        this.AirportName=AirportName;
        this.AirportLocation=AirportLocation;
    }


    public String getAirportName() {
        return AirportName;
    }

    public void setAirportName(String AirportName) {
        this.AirportName = AirportName;
    }

    public String getAirportLocation() {
        return AirportLocation;
    }

    public void setAirportLocation(String AirportLocation) {
        this.AirportLocation = AirportLocation;
    }


}
