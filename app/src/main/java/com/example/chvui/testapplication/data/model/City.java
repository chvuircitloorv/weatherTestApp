package com.example.chvui.testapplication.data.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

/**
 * Created by chvui on 05.12.2017.
 */
// Simple model of city from https://openweathermap.org/
@Entity(tableName = "city")
public class City {

    @SerializedName("id")
    @ColumnInfo(name = "id")
    @PrimaryKey
    private int mId;

    @SerializedName("name")
    @ColumnInfo(name = "name")
    private String mName;

    @SerializedName("country")
    @ColumnInfo(name = "country ")
    private String mCountry;

    @SerializedName("coord")
    @Embedded
    private Coords mCoords;

    public City() {
        //empty
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getCountry() {
        return mCountry;
    }

    public void setCountry(String country) {
        mCountry = country;
    }

    public Coords getCoords() {
        return mCoords;
    }

    public void setCoords(Coords coords) {
        mCoords = coords;
    }

    @Override
    public String toString() {
        return "City{" +
                "mId=" + mId +
                ", mName='" + mName + '\'' +
                ", mCountry='" + mCountry + '\'' +
                ", mCoords=" + mCoords +
                '}';
    }
}
