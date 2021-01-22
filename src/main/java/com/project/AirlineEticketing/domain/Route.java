package com.project.AirlineEticketing.domain;

import javax.persistence.*;

//@Builder
//@Getter
//@Setter

@Table(name = "routes")

public class Route {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer RouteID;
//
//    @Column(name = "DepAirport")
//    private String DepAirport;
//
//    @Column(name = "ArrAirport")
//    private String ArrAirport;
//
//    @Column(name = "Fee")
//    private Integer Fee;
//
//    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
//    @JoinTable(name = "airports",
//            joinColumns = {
//                    @JoinColumn(name = "routes", referencedColumnName = "DepAirport"),
//                    @JoinColumn(name = "routes", referencedColumnName = "ArrAirport")
//            },
//            inverseJoinColumns = {
//                    @JoinColumn(name = "airports", referencedColumnName = "AirportID")
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


    private Long RouteID;
    private Long DepAirport;
    private Long ArrAirport;
    private Integer Fee;

    public Route(){

    }

    public Route(long RouteID, Long DepAirport, Long ArrAirport, Integer Fee){
        this.RouteID=RouteID;
        this.DepAirport=DepAirport;
        this.ArrAirport=ArrAirport;
        this.Fee=Fee;
    }
    public Route(Long DepAirport, Long ArrAirport, Integer Fee){
        this.DepAirport=DepAirport;
        this.ArrAirport=ArrAirport;
        this.Fee=Fee;
    }


    public Long getRouteID() {
        return RouteID;
    }

    public void setRouteID(long RouteID) {
        this.RouteID = RouteID;
    }

    public Long getDepAirport() {
        return DepAirport;
    }

    public void setDepAirport(Long DepAirport) {
        this.DepAirport = DepAirport;
    }

    public Long getArrAirport() {
        return ArrAirport;
    }

    public void setArrAirport(Long ArrAirport) {
        this.ArrAirport = ArrAirport;
    }

    public Integer getFee() {
        return Fee;
    }

    public void setFee(Integer Fee) {
        this.Fee = Fee;
    }


}