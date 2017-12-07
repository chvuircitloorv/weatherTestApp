package com.example.chvui.testapplication.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

/**
 * Created by chvui on 06.12.2017.
 */

public class FiveDayForecast {

    @SerializedName("city")
    private City mCity;
    @SerializedName("cnt")
    private int mNumberOfElements;
    @SerializedName("list")
    private CurrentWeather[] mWeathers;

    public FiveDayForecast() {
        //empty
    }

    public City getCity() {
        return mCity;
    }

    public void setCity(City city) {
        mCity = city;
    }

    public int getNumberOfElements() {
        return mNumberOfElements;
    }

    public void setNumberOfElements(int numberOfElements) {
        mNumberOfElements = numberOfElements;
    }

    public CurrentWeather[] getWeathers() {
        return mWeathers;
    }

    public void setWeathers(CurrentWeather[] weathers) {
        mWeathers = weathers;
    }

    @Override
    public String toString() {
        return "FiveDayForecast{" +
                "mCity=" + mCity +
                ", mNumberOfElements=" + mNumberOfElements +
                ", mWeathers=" + Arrays.toString(mWeathers) +
                '}';
    }
}
