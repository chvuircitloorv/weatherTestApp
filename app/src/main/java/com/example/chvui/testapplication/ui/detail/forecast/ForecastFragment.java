package com.example.chvui.testapplication.ui.detail.forecast;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chvui.testapplication.R;
import com.example.chvui.testapplication.ui.base.BaseFragment;
import com.example.chvui.testapplication.ui.detail.DetailActivity;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by chvui on 06.12.2017.
 */

public class ForecastFragment extends BaseFragment implements ForecastView {

    @BindView(R.id.chart)
    LineChart mChart;

    @Inject
    ForecastPresenter<ForecastView> mPresenter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forecast, container, false);

        setUnBinder(ButterKnife.bind(this, view));

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

        mPresenter.loadForecastWeather(id);
    }

    @Override
    protected void setUp() {

        YAxis leftAxis = mChart.getAxisLeft();
        leftAxis.removeAllLimitLines(); // reset all limit lines to avoid overlapping lines
        leftAxis.setAxisMaximum(50f);
        leftAxis.setAxisMinimum(-70f);

        leftAxis.enableGridDashedLine(10f, 10f, 0f);
        leftAxis.setDrawZeroLine(false);
    }

    @Override
    public void showGraphic(float[] data) {

        ArrayList<Entry> values = new ArrayList<>();

        for (int i = 0; i < data.length; i++) {
            values.add(new Entry(i, data[i]));
        }

        LineDataSet set1;

        set1 = new LineDataSet(values, "Temperature");
        set1.enableDashedHighlightLine(10f, 5f, 0f);
        set1.setColor(Color.BLACK);
        set1.setCircleColor(Color.BLACK);
        set1.setLineWidth(1f);
        set1.setCircleRadius(3f);
        set1.setDrawCircleHole(false);
        set1.setValueTextSize(9f);
        set1.setFormLineWidth(1f);
        set1.setFormLineDashEffect(new DashPathEffect(new float[]{10f, 5f}, 0f));
        set1.setFormSize(15.f);

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);

        LineData dataLine = new LineData(dataSets);

        mChart.setData(dataLine);
        mChart.invalidate();


    }
}
