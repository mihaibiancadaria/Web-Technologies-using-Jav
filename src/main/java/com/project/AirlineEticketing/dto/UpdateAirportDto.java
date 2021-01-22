package com.project.AirlineEticketing.dto;

import com.project.AirlineEticketing.validators.OnlyLetters;

import javax.validation.constraints.*;


public class UpdateAirportDto {
    @OnlyLetters
    private Long AirportID;

    @NotNull(message = "This field is required.")
    @OnlyLetters
    private String AirportName;

    @NotNull(message = "This field is required.")
    private String AirportLocation;

    public UpdateAirportDto(){

    }

    public UpdateAirportDto(Long AirportID, String AirportName, String AirportLocation){
        this.AirportID=AirportID;
        this.AirportName=AirportName;
        this.AirportLocation=AirportLocation;
    }

    public Long getAirportID() {
        return AirportID;
    }

    public void setAirportID(Long AirportID) {
        this.AirportID = AirportID;
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
