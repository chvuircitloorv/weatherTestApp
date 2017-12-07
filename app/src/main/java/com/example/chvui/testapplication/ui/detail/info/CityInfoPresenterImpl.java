package com.example.chvui.testapplication.ui.detail.info;

import com.example.chvui.testapplication.data.model.City;

import javax.inject.Inject;

/**
 * Created by chvui on 06.12.2017.
 */

public class CityInfoPresenterImpl<V extends CityInfoView> implements CityInfoPresenter<V> {

    @Inject
    CityInfoModel mModel;

    private CityInfoView mView;

    @Inject
    CityInfoPresenterImpl() {
        //empty
    }

    @Override
    public void setMvpView(V mvpView) {
        mView = mvpView;
    }

    @Override
    public void loadCityInfo(int id) {
        City city = mModel.getCityById(id);
        mView.showId(String.valueOf(city.getId()));
        mView.showName(city.getName());
        mView.showCountry(city.getCountry());
        mView.showLatitude(String.valueOf(city.getCoords().getLat()));
        mView.showLongitude(String.valueOf(city.getCoords().getLon()));
    }
}
