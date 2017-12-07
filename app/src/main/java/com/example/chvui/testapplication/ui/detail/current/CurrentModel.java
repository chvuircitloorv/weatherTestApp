package com.example.chvui.testapplication.ui.detail.current;

import com.example.chvui.testapplication.data.model.CurrentWeather;

import java.io.IOException;

import retrofit2.Call;

/**
 * Created by chvui on 07.12.2017.
 */

public interface CurrentModel {

    Call<CurrentWeather> geCurrentWeatherConditionsInCity(int id) throws IOException;
}
