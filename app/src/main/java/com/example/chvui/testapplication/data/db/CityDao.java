package com.example.chvui.testapplication.data.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.chvui.testapplication.data.model.City;

import java.util.List;

/**
 * Created by chvui on 06.12.2017.
 */
@Dao
public interface CityDao {

    @Query("SELECT * FROM city")
    List<City> getAll();

    @Query("SELECT * FROM city WHERE id LIKE :id")
    City findCityById(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(City... cities);

}
