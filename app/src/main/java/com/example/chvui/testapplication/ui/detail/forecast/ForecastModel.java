package com.example.chvui.testapplication.ui.detail.forecast;

import com.example.chvui.testapplication.data.model.FiveDayForecast;

import io.reactivex.Single;

/**
 * Created by chvui on 07.12.2017.
 */

public interface ForecastModel {

    Single<FiveDayForecast> getFiveDayForecastByCityId(int id);
}
