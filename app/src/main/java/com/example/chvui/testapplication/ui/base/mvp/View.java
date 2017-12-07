package com.example.chvui.testapplication.ui.base.mvp;

import android.support.annotation.StringRes;

/**
 * Created by chvui on 06.12.2017.
 */

public interface View {

    void showLoading();

    void hideLoading();

    void onError(@StringRes int resId);

    void showMessage(@StringRes int resId);
}
