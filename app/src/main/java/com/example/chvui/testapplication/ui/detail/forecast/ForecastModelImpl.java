package com.example.chvui.testapplication.ui.detail.forecast;

import android.content.Context;

import com.example.chvui.testapplication.data.model.FiveDayForecast;
import com.example.chvui.testapplication.data.network.OpenWeatherMap;
import com.example.chvui.testapplication.data.pref.PreferencesManager;
import com.example.chvui.testapplication.utils.FileUtils;

import java.io.IOException;

import javax.inject.Inject;

import retrofit2.Call;

/**
 * Created by chvui on 07.12.2017.
 */

public class ForecastModelImpl implements ForecastModel {

    @Inject
    OpenWeatherMap mApi;

    @Inject
    PreferencesManager mPreference;

    @Inject
    Context mContext;

    @Inject
    ForecastModelImpl() {

    }

    @Override
    public Call<FiveDayForecast> getFiveDayForecastByCityId(int id) throws IOException {
        return mApi.getFiveDayForecastByCityId(String.valueOf(id), getApiKey());
    }

    //TODO: duplicated
    private String getApiKey() throws IOException {
        String key = mPreference.getApiKey();

        if (key == null) {
            key = FileUtils.getAssetsFileData(mContext.getAssets(), FileUtils.KEY_FILE_NAME);
            mPreference.setApiKey(key);
        }

        return key;
    }
}
