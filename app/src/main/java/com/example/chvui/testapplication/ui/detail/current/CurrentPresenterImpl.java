package com.example.chvui.testapplication.ui.detail.current;

import android.support.annotation.NonNull;

import com.example.chvui.testapplication.R;
import com.example.chvui.testapplication.data.model.Clouds;
import com.example.chvui.testapplication.data.model.CurrentWeather;
import com.example.chvui.testapplication.data.model.Main;
import com.example.chvui.testapplication.data.model.Weather;
import com.example.chvui.testapplication.data.model.Wind;
import com.example.chvui.testapplication.utils.WrapperUtils;

import java.io.IOException;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by chvui on 07.12.2017.
 */

public class CurrentPresenterImpl<V extends CurrentView> implements CurrentPresenter<V> {

    @Inject
    CurrentModel mModel;
    private CurrentView mView;
    private int mCityId;

    @Inject
    CurrentPresenterImpl() {

    }

    @Override
    public void setMvpView(V mvpView) {
        mView = mvpView;
    }

    @Override
    public void loadCurrentWeather(int cityId) {
        mCityId = cityId;
        mView.showLoading();
        try {
            mModel.geCurrentWeatherConditionsInCity(cityId).enqueue(new Callback<CurrentWeather>() {

                @Override
                public void onResponse(@NonNull Call<CurrentWeather> call, @NonNull Response<CurrentWeather> response) {
                    mView.hideLoading();
                    CurrentWeather currentWeather = response.body();
                    if (currentWeather != null) {
                        Weather weather = currentWeather.getWeather()[0];

                        if (weather != null) {
                            mView.showMain(weather.getMain());
                            mView.showDescription(weather.getDescription());
                            mView.showImage(weather.getIcon());
                        }

                        Main main = currentWeather.getMain();

                        if (main != null) {
                            mView.showTemperature(
                                            WrapperUtils.convertTemperatureFromKelvinToCelsius(
                                                    main.getTemperature()));
                            mView.showHumidity(main.getHumidity());
                        }

                        Wind wind = currentWeather.getWind();

                        if (wind != null) {
                            mView.showWind(wind.getSpeed());
                        }

                        Clouds clouds = currentWeather.getClouds();

                        if (clouds != null) {
                            mView.showCloudiness(clouds.getCloudiness());
                        }
                    }
                }

                @Override
                public void onFailure(@NonNull Call<CurrentWeather> call, @NonNull Throwable t) {
                    mView.hideLoading();
                    mView.onError(R.string.error_cant_get_current_weather);
                }
            });
        } catch (IOException e) {
            mView.hideLoading();
            mView.onError(R.string.error_cant_get_current_weather);
        }
    }

    @Override
    public void onRefreshedLayout() {
        loadCurrentWeather(mCityId);
    }
}
