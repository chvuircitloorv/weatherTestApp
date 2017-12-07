package com.example.chvui.testapplication.data.pref;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by chvui on 07.12.2017.
 */
@Singleton
public class AppPreferences implements PreferencesManager {

    private static final String PREF_NAME = "tinkoff_test_app";

    private static final String PREF_KEY = "PREF_KEY";

    private final SharedPreferences mPrefs;

    @Inject
    AppPreferences(Context context) {
        mPrefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public void setApiKey(String key) {
        mPrefs.edit().putString(PREF_KEY, key).apply();
    }

    @Override
    public String getApiKey() {
        return mPrefs.getString(PREF_KEY, null);
    }
}
