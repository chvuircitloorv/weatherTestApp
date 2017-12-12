package com.example.chvui.testapplication.ui.detail.current;

import android.content.Context;
import android.util.Log;

import com.example.chvui.testapplication.data.model.CurrentWeather;
import com.example.chvui.testapplication.data.network.OpenWeatherMap;
import com.example.chvui.testapplication.data.pref.PreferencesManager;
import com.example.chvui.testapplication.utils.FileUtils;

import java.io.IOException;

import javax.inject.Inject;

import io.reactivex.Single;

import static com.example.chvui.testapplication.App.APP_TAG;

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
    public Single<CurrentWeather> geCurrentWeatherConditionsInCity(int id)  {

        return mApi.getCurrentWeatherByCityId(String.valueOf(id), getApiKey());
    }

    private String getApiKey()  {
        String key = mPreference.getApiKey();

        if (key == null) {

            try {
                key = FileUtils.getAssetsFileData(mContext.getAssets(), FileUtils.KEY_FILE_NAME);
            } catch (IOException e) {
                Log.e(APP_TAG, "can't get key", e);
            }
            mPreference.setApiKey(key);
        }

        return key;
    }
}
