package com.example.chvui.testapplication.ui.base.mvp;

/**
 * Created by chvui on 06.12.2017.
 */

public interface Presenter<V extends View> {

    void setMvpView(V mvpView);
}
