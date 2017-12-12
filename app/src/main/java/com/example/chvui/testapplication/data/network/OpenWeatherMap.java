package com.example.chvui.testapplication.data.network;

import com.example.chvui.testapplication.data.model.CurrentWeather;
import com.example.chvui.testapplication.data.model.FiveDayForecast;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by chvui on 05.12.2017.
 */

public interface OpenWeatherMap {

    String URL = "http://api.openweathermap.org/";
    String IMAGE_URL = "http://openweathermap.org/img/w/";

    @GET("data/2.5/weather")
    Single<CurrentWeather> getCurrentWeatherByCityId(@Query("id") String id, @Query("APPID") String key);

    @GET("/data/2.5/forecast")
    Single<FiveDayForecast> getFiveDayForecastByCityId(@Query("id") String id, @Query("APPID") String key);
}
