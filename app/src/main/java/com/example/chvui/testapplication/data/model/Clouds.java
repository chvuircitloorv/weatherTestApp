package com.example.chvui.testapplication.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by chvui on 06.12.2017.
 */

public class Clouds {

    @SerializedName("all")
    private int mCloudiness;

    public Clouds() {
        //empty
    }

    public int getCloudiness() {
        return mCloudiness;
    }

    public void setCloudiness(int cloudiness) {
        mCloudiness = cloudiness;
    }

    @Override
    public String toString() {
        return "Clouds{" +
                "mCloudiness=" + mCloudiness +
                '}';
    }
}
