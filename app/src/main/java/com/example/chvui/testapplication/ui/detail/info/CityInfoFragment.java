package com.example.chvui.testapplication.ui.detail.info;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.chvui.testapplication.R;
import com.example.chvui.testapplication.ui.base.BaseFragment;
import com.example.chvui.testapplication.ui.detail.DetailActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class CityInfoFragment extends BaseFragment implements CityInfoView {

    @BindView(R.id.id)
    TextView mIdTextView;
    @BindView(R.id.name)
    TextView mNameTextView;
    @BindView(R.id.country)
    TextView mCountryTextView;
    @BindView(R.id.latitude)
    TextView mLatitudeTextView;
    @BindView(R.id.longitude)
    TextView mLongitudeTextView;

    @Inject
    CityInfoPresenter<CityInfoView> mPresenter;

    public CityInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info, container, false);

        setUnBinder(ButterKnife.bind(this, view));

        getActivityComponent().inject(this);

        mPresenter.setMvpView(this);

        setUp();

        return view;
    }

    @Override
    protected void setUp() {
        Intent intent = getActivity().getIntent();
        int id = intent.getIntExtra(DetailActivity.CITY_ID_NAME, 0);
        mPresenter.loadCityInfo(id);
    }

    @Override
    public void showId(String id) {
        mIdTextView.setText(id);
    }

    @Override
    public void showName(String name) {
        mNameTextView.setText(name);
    }

    @Override
    public void showCountry(String country) {
        mCountryTextView.setText(country);
    }

    @Override
    public void showLongitude(String longitude) {
        mLongitudeTextView.setText(longitude);
    }

    @Override
    public void showLatitude(String latitude) {
        mLatitudeTextView.setText(latitude);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        mPresenter = null;
    }
}
