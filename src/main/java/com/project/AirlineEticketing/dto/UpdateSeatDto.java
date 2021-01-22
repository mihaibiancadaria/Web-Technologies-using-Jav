package com.project.AirlineEticketing.dto;
import javax.validation.constraints.*;

public class UpdateSeatDto {

    private Long SeatID;
    private Long FlightID;
    private String SeatNumber;

    public UpdateSeatDto(){

    }

    public UpdateSeatDto(Long SeatID, Long FlightID, String SeatNumber){
        this.SeatID=SeatID;
        this.FlightID=FlightID;
        this.SeatNumber=SeatNumber;
    }


    public long getSeatID() {
        return SeatID;
    }

    public void setSeatID(long SeatID) {
        this.SeatID = SeatID;
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
