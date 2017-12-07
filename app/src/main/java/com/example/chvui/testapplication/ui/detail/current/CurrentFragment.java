package com.example.chvui.testapplication.ui.detail.current;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chvui.testapplication.R;
import com.example.chvui.testapplication.data.network.OpenWeatherMap;
import com.example.chvui.testapplication.ui.base.BaseFragment;
import com.example.chvui.testapplication.ui.detail.DetailActivity;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by chvui on 06.12.2017.
 */

public class CurrentFragment extends BaseFragment implements CurrentView {

    private static final String MAIN = "MAIN";
    private static final String DESCRIPTION = "DESCRIPTION";
    private static final String TEMP = "TEMP";
    private static final String HUMIDITY = "HUMIDITY";
    private static final String CLOUD = "CLOUD";
    private static final String WIND = "WIND";

    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.image)
    ImageView mImageView;
    @BindView(R.id.main)
    TextView mMainTextView;
    @BindView(R.id.description)
    TextView mDescriptionTextView;
    @BindView(R.id.temp)
    TextView mTemperatureTextView;
    @BindView(R.id.humidity)
    TextView mHumidityTextView;
    @BindView(R.id.cloud)
    TextView mCloudTextView;
    @BindView(R.id.wind)
    TextView mWindTextView;

    @Inject
    CurrentPresenter<CurrentView> mPresenter;

    private String mImageUrl;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_current, container, false);

        setUnBinder(ButterKnife.bind(this, view));

        if (savedInstanceState != null) {
            mMainTextView.setText(savedInstanceState.getString(MAIN));
            mDescriptionTextView.setText(savedInstanceState.getString(DESCRIPTION));
            mTemperatureTextView.setText(savedInstanceState.getString(TEMP));
            mHumidityTextView.setText(savedInstanceState.getString(HUMIDITY));
            mCloudTextView.setText(savedInstanceState.getString(CLOUD));
            mWindTextView.setText(savedInstanceState.getString(WIND));
            Picasso.with(getContext()).load(mImageUrl).into(mImageView);

        }

        setUp();

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRetainInstance(true);

        getActivityComponent().inject(this);

        mPresenter.setMvpView(this);

        Intent intent = getActivity().getIntent();
        int id = intent.getIntExtra(DetailActivity.CITY_ID_NAME, 0);

        mPresenter.loadCurrentWeather(id);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(MAIN, mMainTextView.getText().toString());
        outState.putString(DESCRIPTION, mDescriptionTextView.getText().toString());
        outState.putString(TEMP, mTemperatureTextView.getText().toString());
        outState.putString(HUMIDITY, mHumidityTextView.getText().toString());
        outState.putString(CLOUD, mCloudTextView.getText().toString());
        outState.putString(WIND, mWindTextView.getText().toString());
    }

    @Override
    protected void setUp() {
        mSwipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        mSwipeRefreshLayout.setOnRefreshListener(mRefreshListener);

    }

    @Override
    public void showImage(String url) {
        mImageUrl = OpenWeatherMap.IMAGE_URL + url + ".png";
        Picasso.with(getContext()).load(mImageUrl).into(mImageView);
    }

    @Override
    public void showMain(String main) {
        mMainTextView.setText(main);
    }

    @Override
    public void showDescription(String description) {
        mDescriptionTextView.setText(description);
    }

    @Override
    public void showTemperature(float temperature) {
        mTemperatureTextView.setText(getString(R.string.temperature, temperature));
    }

    @Override
    public void showHumidity(int humidity) {
        mHumidityTextView.setText(getString(R.string.percent, humidity));
    }

    @Override
    public void showCloudiness(int cloudiness) {
        mCloudTextView.setText(getString(R.string.percent, cloudiness));
    }

    @Override
    public void showWind(float wind) {
        mWindTextView.setText(getString(R.string.meter_in_sec, wind));
    }


    private SwipeRefreshLayout.OnRefreshListener mRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            mSwipeRefreshLayout.setRefreshing(false);
            mPresenter.onRefreshedLayout();
        }
    };
}
