package com.example.chvui.testapplication.ui.list;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.chvui.testapplication.data.model.City;

/**
 * Created by chvui on 06.12.2017.
 */

public class CityAdapter extends ArrayAdapter<City> {


    CityAdapter(@NonNull Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        City city = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(android.R.layout.simple_list_item_1, null);
        }
        if (city != null) {
            ((TextView) convertView.findViewById(android.R.id.text1))
                    .setText(city.getName());
        }
        return convertView;

    }
}