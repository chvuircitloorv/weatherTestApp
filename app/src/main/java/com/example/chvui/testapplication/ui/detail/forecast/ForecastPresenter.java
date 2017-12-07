package com.example.chvui.testapplication.ui.detail.forecast;

import com.example.chvui.testapplication.ui.base.mvp.Presenter;

/**
 * Created by chvui on 07.12.2017.
 */

public interface ForecastPresenter<V extends ForecastView> extends Presenter<V> {

    void loadForecastWeather(int cityId);
}
