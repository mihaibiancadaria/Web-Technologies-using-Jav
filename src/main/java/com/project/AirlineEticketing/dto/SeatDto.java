package com.project.AirlineEticketing.dto;


import javax.validation.constraints.NotNull;


public class SeatDto {


    @NotNull(message = "This field is required.")
    private Long FlightID;

    @NotNull(message = "This field is required.")
    private String SeatNumber;

    public SeatDto(){
    }

    public SeatDto(Long FlightID, String SeatNumber){
        this.FlightID=FlightID;
        this.SeatNumber=SeatNumber;
    }


    public Long getFlightID() {
        return FlightID;
    }

    public void setFlightID(Long FlightID) {
        this.FlightID = FlightID;
    }

    public String getSeatNumber() {
        return SeatNumber;
    }

    public void setSeatNumber(String SeatNumber) {
        this.SeatNumber = SeatNumber;
    }


}
