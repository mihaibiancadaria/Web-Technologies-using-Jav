package com.project.AirlineEticketing.dto;
import javax.validation.constraints.*;
import java.util.Date;

public class UpdateReservationDto {
    private Long ReservationID;
    private Long ClientID;
    private Long FlightID;
    private Date ReservationDate;

    public UpdateReservationDto(){

    }

    public UpdateReservationDto(long ReservationID, long ClientID, long FlightID, Date ReservationDate){
        this.ReservationID=ReservationID;
        this.ClientID=ClientID;
        this.FlightID=FlightID;
        this.ReservationDate=ReservationDate;
    }




    public long getReservationID() {
        return ReservationID;
    }

    public void setReservationID(long ReservationID) {
        this.ReservationID = ReservationID;
    }

    public long getClientID() {
        return ClientID;
    }

    public void setClientID(long ClientID) {
        this.ClientID = ClientID;
    }

    public long getFlightID() {
        return FlightID;
    }

    public void setFlightID(long FlightID) {
        this.FlightID = FlightID;
    }

    public Date getReservationDate() {
        return ReservationDate;
    }

    public void setReservationDate(Date ReservationDate) {
        this.ReservationDate = ReservationDate;
    }

}
