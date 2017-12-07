package com.example.chvui.testapplication.ui.detail.current;

import android.content.Context;

import com.example.chvui.testapplication.data.model.CurrentWeather;
import com.example.chvui.testapplication.data.network.OpenWeatherMap;
import com.example.chvui.testapplication.data.pref.PreferencesManager;
import com.example.chvui.testapplication.utils.FileUtils;

import java.io.IOException;

import javax.inject.Inject;

import retrofit2.Call;

/**
 * Created by chvui on 07.12.2017.
 */

public class CurrentModelImpl implements CurrentModel {

    @Inject
    OpenWeatherMap mApi;

    @Inject
    PreferencesManager mPreference;

    @Inject
    Context mContext;

    @Inject
    CurrentModelImpl() {

    }

    @Override
    public Call<CurrentWeather> geCurrentWeatherConditionsInCity(int id) throws IOException {

        return mApi.getCurrentWeatherByCityId(String.valueOf(id), getApiKey());
    }

    private String getApiKey() throws IOException {
        String key = mPreference.getApiKey();

        if (key == null) {
            key = FileUtils.getAssetsFileData(mContext.getAssets(), FileUtils.KEY_FILE_NAME);
            mPreference.setApiKey(key);
        }

        return key;
    }
}
