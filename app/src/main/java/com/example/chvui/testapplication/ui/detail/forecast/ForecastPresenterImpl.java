package com.example.chvui.testapplication.ui.detail.forecast;

import com.example.chvui.testapplication.R;
import com.example.chvui.testapplication.data.model.FiveDayForecast;
import com.example.chvui.testapplication.utils.WrapperUtils;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

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

        mModel.getFiveDayForecastByCityId(cityId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<FiveDayForecast>() {

                    @Override
                    public void onSuccess(FiveDayForecast fiveDayForecast) {

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
                    public void onError(Throwable e) {
                        mView.onError(R.string.error_cant_get_forecast_weather);
                    }
                });
    }
}
