package com.example.chvui.testapplication.utils;

import com.example.chvui.testapplication.data.model.City;
import com.google.gson.Gson;

/**
 * Created by chvui on 06.12.2017.
 */

public final class WrapperUtils {

    public static City[] convertJsonToCitiesArray(String json) {
        return new Gson().fromJson(json, City[].class);
    }

    public static float convertTemperatureFromKelvinToCelsius(float temperature) {
        return (float) (temperature - 273.15);
    }
}
