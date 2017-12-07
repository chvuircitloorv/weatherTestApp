package com.example.chvui.testapplication.ui.detail.current;

import com.example.chvui.testapplication.ui.base.mvp.View;

/**
 * Created by chvui on 06.12.2017.
 */

public interface CurrentView extends View {

    void showImage(String url);
    void showMain(String main);
    void showDescription(String description);
    void showTemperature(float temperature);
    void showHumidity(int humidity);
    void showCloudiness(int cloudiness);
    void showWind(float wind);
}
