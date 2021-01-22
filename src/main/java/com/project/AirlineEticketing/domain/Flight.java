package com.project.AirlineEticketing.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
//
//@Builder
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
@Table(name = "flights")
public class Flight {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer FlightID;
//
//    @Column(name = "RouteID")
//    private Integer RouteID;
//
//    @Column(name = "FlightCode")
//    private String FlightCode;
//
//    @Column(name = "FlightDate")
//    private Date FlightDate;
//
//    @Column(name = "DepartureTime")
//    private Timestamp DepartureTime;
//
//    @Column(name = "ArrivalTime")
//    private Timestamp ArrivalTime;

//    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
//    @JoinTable(name = "routes",
//            joinColumns = {
//                    @JoinColumn(name = "flights", referencedColumnName = "RouteID")
//            },
//            inverseJoinColumns = {
//                    @JoinColumn(name = "routes", referencedColumnName = "RouteID")
//            }
//    )
//    private Route Route;


    private Long FlightID;
    private Long RouteID;
    private String FlightCode;
    private Date FlightDate;
    private Timestamp DepartureTime;
    private Timestamp ArrivalTime;


    public Flight(){

    }

    public Flight(Long FlightID, Long RouteID, String FlightCode, Date FlightDate, Timestamp DepartureTime, Timestamp ArrivalTime){
        this.FlightID=FlightID;
        this.RouteID=RouteID;
        this.FlightCode=FlightCode;
        this.FlightDate=FlightDate;
        this.DepartureTime=DepartureTime;
        this.ArrivalTime=ArrivalTime;
    }
    public Flight(Long RouteID, String FlightCode, Date FlightDate, Timestamp DepartureTime, Timestamp ArrivalTime){
        this.RouteID=RouteID;
        this.FlightCode=FlightCode;
        this.FlightDate=FlightDate;
        this.DepartureTime=DepartureTime;
        this.ArrivalTime=ArrivalTime;
    }



    public long getFlightID() {
        return FlightID;
    }

    public void setFlightID(long FlightID) {
        this.FlightID = FlightID;
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
