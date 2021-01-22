package com.project.AirlineEticketing.dto;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Date;


public class FlightDto {


    @NotNull(message = "This field is required.")
    private Long RouteID;

    @NotNull(message = "This field is required.")
    private String FlightCode;

    @NotNull(message = "This field is required.")
    private Date FlightDate;

    @NotNull(message = "This field is required.")
    private Timestamp DepartureTime;

    @NotNull(message = "This field is required.")
    private Timestamp ArrivalTime;

    public FlightDto(){

    }

    public FlightDto(Long RouteID, String FlightCode, Date FlightDate, Timestamp DepartureTime, Timestamp ArrivalTime){
        this.RouteID=RouteID;
        this.FlightCode=FlightCode;
        this.FlightDate=FlightDate;
        this.DepartureTime=DepartureTime;
        this.ArrivalTime=ArrivalTime;
    }



    public long getRouteID() {
        return RouteID;
    }

    public void setRouteID(long RouteID) {
        this.RouteID = RouteID;
    }

    public String getFlightCode() {
        return FlightCode;
    }

    public void setFlightCode(String FlightCode) {
        this.FlightCode = FlightCode;
    }

    public Date getFlightDate() {
        return FlightDate;
    }

    public void setFlightDate(Date FlightDate) {
        this.FlightDate = FlightDate;
    }

    public Timestamp getDepartureTime() {
        return DepartureTime;
    }

    public void setDepartureTime(Timestamp DepartureTime) {
        this.DepartureTime = DepartureTime;
    }

    public Timestamp getArrivalTime() {
        return ArrivalTime;
    }

    public void setArrivalTime(Timestamp ArrivalTime) {
        this.ArrivalTime = ArrivalTime;
    }


}