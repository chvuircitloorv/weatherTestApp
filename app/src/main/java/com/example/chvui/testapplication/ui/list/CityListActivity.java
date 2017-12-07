package com.example.chvui.testapplication.ui.list;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.example.chvui.testapplication.R;
import com.example.chvui.testapplication.data.model.City;
import com.example.chvui.testapplication.ui.detail.DetailActivity;
import com.example.chvui.testapplication.ui.base.BaseActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class CityListActivity extends BaseActivity implements CityListView {

    @BindView(R.id.list)
    ListView mListView;

    @Inject
    CityListPresenter<CityListView> mPresenter;

    private CityAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_list);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.setMvpView(this);

        setUp();
    }

    @Override
    public void showCities(List<City> list) {
        mAdapter.addAll(list);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showDetailView(int cityId) {
        Intent intent = DetailActivity.getCallingIntent(cityId, this);
        startActivity(intent);
    }

    @Override
    protected void setUp() {

        mAdapter = new CityAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1);

        mListView.setAdapter(mAdapter);

        mPresenter.onViewInitialized();
    }

    @Override
    protected void onDestroy() {
        mPresenter.setMvpView(null);
        mListView.setAdapter(null);

        mPresenter = null;
        mAdapter = null;

        super.onDestroy();
    }

    @OnItemClick(R.id.list)
    void onItemSelected(int position) {
        City city = mAdapter.getItem(position);
        mPresenter.onCityClicked(city);
    }
}
