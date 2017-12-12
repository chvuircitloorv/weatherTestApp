package com.example.chvui.testapplication;

import android.app.Application;

import com.example.chvui.testapplication.di.component.ApplicationComponent;
import com.example.chvui.testapplication.di.component.DaggerApplicationComponent;
import com.example.chvui.testapplication.di.module.ApplicationModule;

/**
 * Created by chvui on 06.12.2017.
 */

public class App extends Application {

    public static String APP_TAG = "app";

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }

}
