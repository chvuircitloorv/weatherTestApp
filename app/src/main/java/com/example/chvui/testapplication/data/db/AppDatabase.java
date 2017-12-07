package com.example.chvui.testapplication.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.chvui.testapplication.data.model.City;

/**
 * Created by chvui on 06.12.2017.
 */
@Database(entities = {City.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public static final String DB_NAME = "weather_db";

    public abstract CityDao cityDao();

}
