package com.project.AirlineEticketing.dto;

import javax.validation.constraints.NotNull;

public class RouteDto {

    @NotNull(message = "This field is required.")
    private Long DepAirport;

    @NotNull(message = "This field is required.")
    private Long ArrAirport;

    @NotNull(message = "This field is required.")
    private Integer Fee;

    public RouteDto(){
    }


    public RouteDto( Long DepAirport, Long ArrAirport, Integer Fee){
        this.DepAirport=DepAirport;
        this.ArrAirport=ArrAirport;
        this.Fee=Fee;
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
