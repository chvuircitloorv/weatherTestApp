package com.example.chvui.testapplication.ui.detail.forecast;

import com.example.chvui.testapplication.data.model.FiveDayForecast;

import java.io.IOException;

import retrofit2.Call;

/**
 * Created by chvui on 07.12.2017.
 */

public interface ForecastModel {

    Call<FiveDayForecast> getFiveDayForecastByCityId(int id) throws IOException;
}
