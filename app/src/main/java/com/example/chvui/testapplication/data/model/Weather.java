package com.example.chvui.testapplication.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by chvui on 06.12.2017.
 */

public class Weather {

    @SerializedName("id")
    private int mId;
    @SerializedName("main")
    private String mMain;
    @SerializedName("description")
    private String mDescription;
    @SerializedName("icon")
    private String mIcon;

    public Weather() {
        //empty
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getMain() {
        return mMain;
    }

    public void setMain(String main) {
        mMain = main;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "mId=" + mId +
                ", mMain='" + mMain + '\'' +
                ", mDescription='" + mDescription + '\'' +
                ", mIcon='" + mIcon + '\'' +
                '}';
    }
}
