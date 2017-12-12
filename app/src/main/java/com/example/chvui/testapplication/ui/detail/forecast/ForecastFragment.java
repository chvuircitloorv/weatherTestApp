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
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by chvui on 06.12.2017.
 */

public class ForecastFragment extends BaseFragment implements ForecastView {

    private static final String TEMP = "temp";

    @BindView(R.id.chart)
    LineChart mChart;

    @Inject
    ForecastPresenter<ForecastView> mPresenter;

    private float[] mTemperatures;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forecast, container, false);

        setUnBinder(ButterKnife.bind(this, view));

        if (savedInstanceState != null) {
            showGraphic(savedInstanceState.getFloatArray(TEMP));
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

        mPresenter.loadForecastWeather(id);

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        if (mTemperatures != null) {
            outState.putFloatArray(TEMP, mTemperatures);
        }
    }


    @Override
    protected void setUp() {

        YAxis leftAxis = mChart.getAxisLeft();
        leftAxis.removeAllLimitLines();
        leftAxis.setAxisMaximum(50f);
        leftAxis.setAxisMinimum(-70f);

        leftAxis.enableGridDashedLine(10f, 10f, 0f);
        leftAxis.setDrawZeroLine(false);
    }

    @Override
    public void showGraphic(float[] data) {
        mTemperatures = data;

        if (mTemperatures == null || mChart == null) {
            return;
        }

        ArrayList<Entry> values = new ArrayList<>();

        for (int i = 0; i < mTemperatures.length; i++) {
            values.add(new Entry(i, mTemperatures[i]));
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

        XAxis xAxis = mChart.getXAxis();
        xAxis.setValueFormatter(new MyYAxisValueFormatter());

        mChart.setData(dataLine);
        mChart.invalidate();
    }

    public static class MyYAxisValueFormatter implements IAxisValueFormatter {

        private static final String FORMAT = "HHaa EEE";
        private static final long THREE_HOURS = 10800000;

        private SimpleDateFormat mFormat;
        private Date mDate;
        private long mTime;

        MyYAxisValueFormatter() {
            mDate = new Date();
            mTime = mDate.getTime();
            mFormat = new SimpleDateFormat(FORMAT, Locale.getDefault());
        }

        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            mDate.setTime(mTime + ((int) value + 1) * THREE_HOURS);

            return mFormat.format(mDate);
        }

    }
}
