package com.project.AirlineEticketing.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

public class Airport {


    private Long AirportID;
    private String AirportName;
    private String AirportLocation;

    public Airport() {

    }

    public Airport(Long AirportID, String AirportName, String AirportLocation){
        this.AirportID=AirportID;
        this.AirportName=AirportName;
        this.AirportLocation=AirportLocation;
    }

    public Airport(String AirportName, String AirportLocation){
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
