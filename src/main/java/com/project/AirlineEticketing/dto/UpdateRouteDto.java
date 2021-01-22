package com.project.AirlineEticketing.dto;
import javax.validation.constraints.*;

public class UpdateRouteDto {
    private Long RouteID;
    private Long DepAirport;
    private Long ArrAirport;
    private Integer Fee;

    public UpdateRouteDto(){

    }

    public UpdateRouteDto(long RouteID, Long DepAirport, Long ArrAirport, Integer Fee){
        this.RouteID=RouteID;
        this.DepAirport=DepAirport;
        this.ArrAirport=ArrAirport;
        this.Fee=Fee;
    }



    public long getRouteID() {
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
