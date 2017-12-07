package com.example.chvui.testapplication.ui.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.example.chvui.testapplication.R;
import com.example.chvui.testapplication.ui.base.BaseActivity;
import com.example.chvui.testapplication.ui.detail.current.CurrentFragment;
import com.example.chvui.testapplication.ui.detail.forecast.ForecastFragment;
import com.example.chvui.testapplication.ui.detail.info.CityInfoFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends BaseActivity {

    public static final String CITY_ID_NAME = "CITY_ID";

    @BindView(R.id.viewpager)
    ViewPager mViewPager;

    public static Intent getCallingIntent(int cityId, Context context) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(CITY_ID_NAME, cityId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        setUp();
    }

    @Override
    protected void setUp() {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new CityInfoFragment(), getString(R.string.city));
        adapter.addFragment(new CurrentFragment(), getString(R.string.current));
        adapter.addFragment(new ForecastFragment(), getString(R.string.forecast));
        mViewPager.setAdapter(adapter);

    }

}
