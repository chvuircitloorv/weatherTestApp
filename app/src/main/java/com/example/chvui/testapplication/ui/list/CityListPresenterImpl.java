package com.example.chvui.testapplication.ui.list;

import com.example.chvui.testapplication.R;
import com.example.chvui.testapplication.data.model.City;

import java.io.IOException;

import javax.inject.Inject;

/**
 * Created by chvui on 06.12.2017.
 */

public class CityListPresenterImpl<V extends CityListView> implements CityListPresenter<V> {

    @Inject
    CityListModel mModel;

    private CityListView mView;

    @Inject
    CityListPresenterImpl() {
        //empty
    }
    @Override
    public void onCityClicked(City city) {
        mView.showDetailView(city.getId());
    }

    @Override
    public void onViewInitialized() {
        try {
            mView.showCities(mModel.getCities());
        } catch (IOException e) {
            mView.onError(R.string.error_cant_load_cities);
        }
    }

    @Override
    public void setMvpView(CityListView mvpView) {
        mView = mvpView;
    }
}
