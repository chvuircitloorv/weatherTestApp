package com.example.chvui.testapplication.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by chvui on 06.12.2017.
 */

public class Main {

    @SerializedName("temp")
    private float mTemperature;
    @SerializedName("pressure")
    private float mPressure;
    @SerializedName("humidity")
    private int mHumidity;
    @SerializedName("temp_min")
    private float mTemperatureMin;
    @SerializedName("temp_max")
    private float mTemperatureMax;

    public Main() {
        //empty
    }

    public float getTemperature() {
        return mTemperature;
    }

    public void setTemperature(float temperature) {
        mTemperature = temperature;
    }

    public float getPressure() {
        return mPressure;
    }

    public void setPressure(int pressure) {
        mPressure = pressure;
    }

    public int getHumidity() {
        return mHumidity;
    }

    public void setHumidity(int humidity) {
        mHumidity = humidity;
    }

    public float getTemperatureMin() {
        return mTemperatureMin;
    }

    public void setTemperatureMin(float temperatureMin) {
        mTemperatureMin = temperatureMin;
    }

    public float getTemperatureMax() {
        return mTemperatureMax;
    }

    public void setTemperatureMax(float temperatureMax) {
        mTemperatureMax = temperatureMax;
    }

    @Override
    public String toString() {
        return "Main{" +
                "mTemperature=" + mTemperature +
                ", mPressure=" + mPressure +
                ", mHumidity=" + mHumidity +
                ", mTemperatureMin=" + mTemperatureMin +
                ", mTemperatureMax=" + mTemperatureMax +
                '}';
    }
}
