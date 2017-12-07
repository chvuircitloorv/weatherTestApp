package com.example.chvui.testapplication.ui.list;

import com.example.chvui.testapplication.data.model.City;
import com.example.chvui.testapplication.ui.base.mvp.View;

import java.util.List;

/**
 * Created by chvui on 06.12.2017.
 */

public interface CityListView extends View {

    void showCities(List<City> list);

    void showDetailView(int cityId);
}
