package com.example.chvui.testapplication.ui.detail.info;

import com.example.chvui.testapplication.ui.base.mvp.View;

/**
 * Created by chvui on 06.12.2017.
 */

public interface CityInfoView extends View {

    void showId(String id);
    void showName(String name);
    void showCountry(String country);
    void showLongitude(String longitude);
    void showLatitude(String latitude);
}
