package com.example.chvui.testapplication.di.module;

import com.example.chvui.testapplication.di.PerActivity;
import com.example.chvui.testapplication.ui.detail.current.CurrentModel;
import com.example.chvui.testapplication.ui.detail.current.CurrentModelImpl;
import com.example.chvui.testapplication.ui.detail.current.CurrentPresenter;
import com.example.chvui.testapplication.ui.detail.current.CurrentPresenterImpl;
import com.example.chvui.testapplication.ui.detail.current.CurrentView;
import com.example.chvui.testapplication.ui.detail.forecast.ForecastModel;
import com.example.chvui.testapplication.ui.detail.forecast.ForecastModelImpl;
import com.example.chvui.testapplication.ui.detail.forecast.ForecastPresenter;
import com.example.chvui.testapplication.ui.detail.forecast.ForecastPresenterImpl;
import com.example.chvui.testapplication.ui.detail.forecast.ForecastView;
import com.example.chvui.testapplication.ui.detail.info.CityInfoModel;
import com.example.chvui.testapplication.ui.detail.info.CityInfoModelImpl;
import com.example.chvui.testapplication.ui.detail.info.CityInfoPresenter;
import com.example.chvui.testapplication.ui.detail.info.CityInfoPresenterImpl;
import com.example.chvui.testapplication.ui.detail.info.CityInfoView;
import com.example.chvui.testapplication.ui.list.CityListModel;
import com.example.chvui.testapplication.ui.list.CityListModelImpl;
import com.example.chvui.testapplication.ui.list.CityListPresenter;
import com.example.chvui.testapplication.ui.list.CityListPresenterImpl;
import com.example.chvui.testapplication.ui.list.CityListView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by chvui on 06.12.2017.
 */
@Module
public class ActivityModule {

    @Provides
    @PerActivity
    CityListModel provideCityListModel(CityListModelImpl model) {
        return model;
    }

    @Provides
    @PerActivity
    CityListPresenter<CityListView> provideCityListPresenter(CityListPresenterImpl<CityListView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    CityInfoModel provideCityInfoModel(CityInfoModelImpl model) {
        return model;
    }

    @Provides
    @PerActivity
    CityInfoPresenter<CityInfoView> provideCityInfoPresenter(CityInfoPresenterImpl<CityInfoView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    CurrentModel provideCurrentModel(CurrentModelImpl model) {
        return model;
    }

    @Provides
    @PerActivity
    CurrentPresenter<CurrentView> provideCurrentPresenter(CurrentPresenterImpl<CurrentView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    ForecastModel provideForecastModel(ForecastModelImpl model) {
        return model;
    }

    @Provides
    @PerActivity
    ForecastPresenter<ForecastView> provideForecastPresenter(ForecastPresenterImpl<ForecastView> presenter) {
        return presenter;
    }
}
