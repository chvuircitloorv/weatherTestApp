package com.example.chvui.testapplication.ui.list;

import com.example.chvui.testapplication.data.model.City;

import java.io.IOException;
import java.util.List;

/**
 * Created by chvui on 06.12.2017.
 */

public interface CityListModel {

    List<City> getCities() throws IOException;
}
