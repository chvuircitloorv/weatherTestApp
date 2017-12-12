package com.example.chvui.testapplication.di.module;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.chvui.testapplication.data.db.AppDatabase;
import com.example.chvui.testapplication.data.network.OpenWeatherMap;
import com.example.chvui.testapplication.data.pref.AppPreferences;
import com.example.chvui.testapplication.data.pref.PreferencesManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by chvui on 06.12.2017.
 */

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Singleton
    @Provides
    AppDatabase provideAppDataBase(Context context) {
        return Room.databaseBuilder(context,
                AppDatabase.class, AppDatabase.DB_NAME).allowMainThreadQueries().build();
    }

    @Singleton
    @Provides
    OpenWeatherMap provideOpenWeatherMap() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(OpenWeatherMap.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(OpenWeatherMap.class);
    }

    @Singleton
    @Provides
    PreferencesManager providePreferencesManager(AppPreferences appPreferences) {
        return appPreferences;
    }
}
