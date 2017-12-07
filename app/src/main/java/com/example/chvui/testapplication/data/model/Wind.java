package com.example.chvui.testapplication.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by chvui on 06.12.2017.
 */

public class Wind {

    @SerializedName("speed")
    private float mSpeed;
    @SerializedName("deg")
    private float mDegree;

    public Wind() {
        // empty
    }

    public float getSpeed() {
        return mSpeed;
    }

    public void setSpeed(float speed) {
        mSpeed = speed;
    }

    public float getDegree() {
        return mDegree;
    }

    public void setDegree(int degree) {
        mDegree = degree;
    }

    @Override
    public String toString() {
        return "Wind{" +
                "mSpeed=" + mSpeed +
                ", mDegree=" + mDegree +
                '}';
    }
}
