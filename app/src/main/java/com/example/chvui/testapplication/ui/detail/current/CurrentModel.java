package com.example.chvui.testapplication.ui.detail.current;

import com.example.chvui.testapplication.data.model.CurrentWeather;

import io.reactivex.Single;

/**
 * Created by chvui on 07.12.2017.
 */

public interface CurrentModel {

    Single<CurrentWeather> geCurrentWeatherConditionsInCity(int id);
}
