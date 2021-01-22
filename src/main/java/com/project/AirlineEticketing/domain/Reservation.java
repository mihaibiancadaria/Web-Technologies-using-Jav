package com.project.AirlineEticketing.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

//@Builder
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
@Table(name = "reservations")

public class Reservation {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer ReservationID;
//
//    @Column(name = "ClientID")
//    private Integer ClientID;
//
//    @Column(name = "FlightID")
//    private Integer FlightID;
//
//    @Column(name = "ReservationDate")
//    private Date ReservationDate;
//
//    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
//    @JoinTable(name = "clients",
//            joinColumns = {
//                    @JoinColumn(name = "reservations", referencedColumnName = "ClientID")
//            },
//            inverseJoinColumns = {
//                    @JoinColumn(name = "clients", referencedColumnName = "ClientID")
//            }
//    )
//    private Client Client;
//
//    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
//    @JoinTable(name = "flights",
//            joinColumns = {
//                    @JoinColumn(name = "reservations", referencedColumnName = "FlightID")
//            },
//            inverseJoinColumns = {
//                    @JoinColumn(name = "flights", referencedColumnName = "FlightID")
//            }
//    )
//    private Flight Flight;



    private Long ReservationID;
    private Long ClientID;
    private Long FlightID;
    private Date ReservationDate;

    public Reservation(){

    }

    public Reservation(long ReservationID, long ClientID, long FlightID, Date ReservationDate){
        this.ReservationID=ReservationID;
        this.ClientID=ClientID;
        this.FlightID=FlightID;
        this.ReservationDate=ReservationDate;
    }

    public Reservation(long ClientID, long FlightID, Date ReservationDate){
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
