package com.solo.iwanawatch.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.solo.iwanawatch.R;
import com.solo.iwanawatch.data.MovieDATA;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<MovieDATA> {

    public ListAdapter(Context context, ArrayList<MovieDATA> movieDATAArrayList) {
        super(context, R.layout.activity_item_list, movieDATAArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        MovieDATA movieDATA = getItem(position);
        if (convertView==null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_item_list, parent, false);
        }
        TextView movieName = convertView.findViewById(R.id.movieListName);
        TextView movieYear = convertView.findViewById(R.id.movieListYear);

        movieName.setText(movieDATA.getName());
        movieYear.setText(movieDATA.getYear());

        return convertView;
    }
}
