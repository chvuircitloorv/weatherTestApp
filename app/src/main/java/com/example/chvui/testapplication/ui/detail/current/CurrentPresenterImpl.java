package com.example.chvui.testapplication.ui.detail.current;

import com.example.chvui.testapplication.R;
import com.example.chvui.testapplication.data.model.Clouds;
import com.example.chvui.testapplication.data.model.CurrentWeather;
import com.example.chvui.testapplication.data.model.Main;
import com.example.chvui.testapplication.data.model.Weather;
import com.example.chvui.testapplication.data.model.Wind;
import com.example.chvui.testapplication.utils.WrapperUtils;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

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

        mModel.geCurrentWeatherConditionsInCity(mCityId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<CurrentWeather>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println();
            }

            @Override
            public void onSuccess(CurrentWeather currentWeather) {
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
                mView.hideLoading();

            }

            @Override
            public void onError(Throwable e) {
                mView.hideLoading();
                mView.onError(R.string.error_cant_get_current_weather);
            }
        });
    }

    @Override
    public void onRefreshedLayout() {
        loadCurrentWeather(mCityId);
    }

}
