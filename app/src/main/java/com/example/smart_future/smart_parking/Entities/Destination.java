package com.example.smart_future.smart_parking.Entities;

/**
 * Created by Zach on 1/4/2018.
 */

public class Destination {

    private String name;
    private double longitude;
    private double latitude;

    // Getters
    public String getName() { return name; }

    public double getLongitude() { return longitude; }

    public double getLatitude() { return latitude; }


    // Setters
    public void setName(String name) { name = this.name; }

    public void setLongitude(double longitude) { longitude = this.longitude; }

    public void setLatitude(double latitude) { latitude = this.latitude; }

}
