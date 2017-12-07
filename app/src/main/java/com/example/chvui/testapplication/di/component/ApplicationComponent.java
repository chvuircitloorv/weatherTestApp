package com.example.chvui.testapplication.di.component;

import android.content.Context;

import com.example.chvui.testapplication.data.db.AppDatabase;
import com.example.chvui.testapplication.data.network.OpenWeatherMap;
import com.example.chvui.testapplication.data.pref.PreferencesManager;
import com.example.chvui.testapplication.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by chvui on 06.12.2017.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    OpenWeatherMap getOpenWeatherMap();

    AppDatabase getAppDataBase();

    Context getContext();

    PreferencesManager getPreferenceManager();
}
