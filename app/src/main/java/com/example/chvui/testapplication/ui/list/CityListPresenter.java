package com.example.chvui.testapplication.ui.list;

import com.example.chvui.testapplication.data.model.City;
import com.example.chvui.testapplication.ui.base.mvp.Presenter;

/**
 * Created by chvui on 06.12.2017.
 */

public interface CityListPresenter<V extends CityListView> extends Presenter<V> {

    void onCityClicked(City city);

    void onViewInitialized();
}
