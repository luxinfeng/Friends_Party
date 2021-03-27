package com.example.server.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author luxinfeng
 * @date 2021/3/26 22:12
 */

@Getter
@Setter
public class GeoCoordinate {
    private double latitude;
    private double longitude;

    public GeoCoordinate(){}

    public GeoCoordinate(String location){
        String[] params = location.split(",");
        this.latitude = Double.valueOf(params[1]);
        this.longitude = Double.valueOf(params[0]);
    }
    public GeoCoordinate(double latitude, double longitude){
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
