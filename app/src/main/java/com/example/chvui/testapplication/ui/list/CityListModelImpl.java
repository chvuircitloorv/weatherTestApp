package com.example.chvui.testapplication.ui.list;

import android.content.Context;

import com.example.chvui.testapplication.App;
import com.example.chvui.testapplication.data.db.AppDatabase;
import com.example.chvui.testapplication.data.model.City;
import com.example.chvui.testapplication.utils.FileUtils;
import com.example.chvui.testapplication.utils.WrapperUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by chvui on 06.12.2017.
 */

public class CityListModelImpl implements CityListModel {

    @Inject
    AppDatabase mDatabase;
    @Inject
    Context mContext;

    @Inject
    CityListModelImpl() {
        // empty
    }

    @Override
    public List<City> getCities() throws IOException {
        List<City> list = mDatabase.cityDao().getAll();
        if (list.size() == 0) {
            String json = FileUtils.getAssetsFileData(mContext.getAssets(), FileUtils.CITIES_FILE_NAME);
            City[] cities = WrapperUtils.convertJsonToCitiesArray(json);
            mDatabase.cityDao().insertAll(cities);
            list = Arrays.asList(cities);
        }
        return list;
    }
}
