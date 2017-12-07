package com.example.chvui.testapplication.ui.detail.current;

import com.example.chvui.testapplication.ui.base.mvp.Presenter;

/**
 * Created by chvui on 07.12.2017.
 */

public interface CurrentPresenter<V extends CurrentView> extends Presenter<V> {

    void loadCurrentWeather(int cityId);
    void onRefreshedLayout();

}
