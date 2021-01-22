package com.project.AirlineEticketing.dto;



import javax.validation.constraints.NotNull;

import java.util.Date;


public class ReservationDto {

    @NotNull(message = "This field is required.")
    private Long ClientID;

    @NotNull(message = "This field is required.")
    private Long FlightID;

    @NotNull(message = "This field is required.")
    private Date ReservationDate;

    public ReservationDto(){
    }

    public ReservationDto( long ClientID, long FlightID, Date ReservationDate){
        this.ClientID=ClientID;
        this.FlightID=FlightID;
        this.ReservationDate=ReservationDate;
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
