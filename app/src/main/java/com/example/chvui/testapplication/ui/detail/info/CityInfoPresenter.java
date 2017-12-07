package com.example.chvui.testapplication.ui.detail.info;

import com.example.chvui.testapplication.ui.base.mvp.Presenter;

/**
 * Created by chvui on 06.12.2017.
 */

public interface CityInfoPresenter<V extends CityInfoView> extends Presenter<V> {

    void loadCityInfo(int id);

}
