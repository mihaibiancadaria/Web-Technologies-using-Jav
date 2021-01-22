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
@Table(name = "seats")
public class Seat {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer SeatID;
//
//    @Column(name = "FlightID")
//    private Integer FlightID;
//
//    @Column(name = "SeatNumber")
//    private String SeatNumber;
//
//    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
//    @JoinTable(name = "flights",
//            joinColumns = {
//                    @JoinColumn(name = "seats", referencedColumnName = "FlightID")
//            },
//            inverseJoinColumns = {
//                    @JoinColumn(name = "flights", referencedColumnName = "FlightID")
//            }
//    )
//    private Flight Flight;


    private Long SeatID;
    private Long FlightID;
    private String SeatNumber;

    public Seat(){

    }

    public Seat(Long SeatID, Long FlightID, String SeatNumber){
        this.SeatID=SeatID;
        this.FlightID=FlightID;
        this.SeatNumber=SeatNumber;
    }
    public Seat(Long FlightID, String SeatNumber){
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
