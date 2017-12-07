package com.example.chvui.testapplication.ui.detail.forecast;

import android.support.annotation.NonNull;

import com.example.chvui.testapplication.R;
import com.example.chvui.testapplication.data.model.FiveDayForecast;
import com.example.chvui.testapplication.utils.WrapperUtils;

import java.io.IOException;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by chvui on 07.12.2017.
 */

public class ForecastPresenterImpl<V extends ForecastView> implements ForecastPresenter<V> {

    @Inject
    ForecastModel mModel;
    private ForecastView mView;

    @Inject
    ForecastPresenterImpl() {

    }

    @Override
    public void setMvpView(V mvpView) {
        mView = mvpView;
    }

    @Override
    public void loadForecastWeather(int cityId) {
        try {
            mModel.getFiveDayForecastByCityId(cityId).enqueue(new Callback<FiveDayForecast>() {
                @Override
                public void onResponse(@NonNull Call<FiveDayForecast> call, @NonNull Response<FiveDayForecast> response) {
                    FiveDayForecast fiveDayForecast = response.body();

                    if (fiveDayForecast != null) {
                        float[] temperatures = new float[fiveDayForecast.getNumberOfElements()];

                        for (int i = 0; i < temperatures.length; i++) {
                            temperatures[i] = WrapperUtils.convertTemperatureFromKelvinToCelsius(
                                    fiveDayForecast.getWeathers()[i].getMain().getTemperature());
                        }
                        mView.showGraphic(temperatures);
                    }
                }

                @Override
                public void onFailure(Call<FiveDayForecast> call, Throwable t) {
                    mView.onError(R.string.error_cant_get_forecast_weather);
                }
            });
        } catch (IOException e) {
            mView.onError(R.string.error_cant_get_forecast_weather);
        }
    }
}
