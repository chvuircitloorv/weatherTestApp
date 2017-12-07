package com.example.chvui.testapplication.ui.detail.info;

import com.example.chvui.testapplication.data.db.AppDatabase;
import com.example.chvui.testapplication.data.model.City;

import javax.inject.Inject;

/**
 * Created by chvui on 06.12.2017.
 */

public class CityInfoModelImpl implements CityInfoModel {

    @Inject
    AppDatabase mDatabase;

    @Inject
    CityInfoModelImpl() {
        //empty
    }

    @Override
    public City getCityById(int id) {
        return mDatabase.cityDao().findCityById(id);
    }
}
