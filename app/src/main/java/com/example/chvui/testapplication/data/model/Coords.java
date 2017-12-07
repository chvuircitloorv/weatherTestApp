package com.example.chvui.testapplication.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by chvui on 06.12.2017.
 */
// Simple model of city from https://openweathermap.org/
public class Coords {

    @SerializedName("lon")
    private float lon;
    @SerializedName("lat")
    private float lat;

    public Coords() {
        //empty
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "Coords{" +
                "lon=" + lon +
                ", lat=" + lat +
                '}';
    }
}
