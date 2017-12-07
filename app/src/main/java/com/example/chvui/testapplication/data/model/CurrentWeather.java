package com.example.chvui.testapplication.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

/**
 * Created by chvui on 06.12.2017.
 */

public class CurrentWeather {

    @SerializedName("coord")
    private Coords mCoords;
    @SerializedName("weather")
    private Weather[] mWeather;
    @SerializedName("main")
    private Main mMain;
    @SerializedName("wind")
    private Wind mWind;
    @SerializedName("clouds")
    private Clouds mClouds;
    @SerializedName("id")
    private int mCityId;
    @SerializedName("name")
    private String mCityName;
    @SerializedName("dt")
    private int mDate;

    public CurrentWeather() {
        //empty
    }

    public Coords getCoords() {
        return mCoords;
    }

    public void setCoords(Coords coords) {
        mCoords = coords;
    }

    public Weather[] getWeather() {
        return mWeather;
    }

    public void setWeather(Weather[] weather) {
        mWeather = weather;
    }

    public Main getMain() {
        return mMain;
    }

    public void setMain(Main main) {
        mMain = main;
    }

    public Wind getWind() {
        return mWind;
    }

    public void setWind(Wind wind) {
        mWind = wind;
    }

    public Clouds getClouds() {
        return mClouds;
    }

    public void setClouds(Clouds clouds) {
        mClouds = clouds;
    }

    public int getCityId() {
        return mCityId;
    }

    public void setCityId(int cityId) {
        mCityId = cityId;
    }

    public String getCityName() {
        return mCityName;
    }

    public void setCityName(String cityName) {
        mCityName = cityName;
    }

    public int getDate() {
        return mDate;
    }

    public void setDate(int date) {
        mDate = date;
    }

    @Override
    public String toString() {
        return "CurrentWeather{" +
                "mCoords=" + mCoords +
                ", mWeather=" + Arrays.toString(mWeather) +
                ", mMain=" + mMain +
                ", mWind=" + mWind +
                ", mClouds=" + mClouds +
                ", mCityId=" + mCityId +
                ", mCityName='" + mCityName + '\'' +
                ", mDate=" + mDate +
                '}';
    }
}
