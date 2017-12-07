package com.example.chvui.testapplication.di.component;

import com.example.chvui.testapplication.di.PerActivity;
import com.example.chvui.testapplication.di.module.ActivityModule;
import com.example.chvui.testapplication.ui.detail.DetailActivity;
import com.example.chvui.testapplication.ui.detail.current.CurrentFragment;
import com.example.chvui.testapplication.ui.detail.forecast.ForecastFragment;
import com.example.chvui.testapplication.ui.detail.info.CityInfoFragment;
import com.example.chvui.testapplication.ui.list.CityListActivity;

import dagger.Component;

/**
 * Created by chvui on 06.12.2017.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(CityListActivity activity);

    void inject(DetailActivity activity);

    void inject(CityInfoFragment fragment);

    void inject(CurrentFragment fragment);

    void inject(ForecastFragment fragment);
}
