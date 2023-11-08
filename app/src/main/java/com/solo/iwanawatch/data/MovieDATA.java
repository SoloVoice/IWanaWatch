package com.solo.iwanawatch.data;

import android.widget.EditText;

import lombok.Getter;
import lombok.Setter;

public class MovieDATA {
    private String name;
    private String year;
    private String rating;
    private Boolean watched;

    public MovieDATA(String name, String year, String rating, Boolean watched) {
        this.name = name;
        this.year = year;
        this.rating = rating;
        this.watched = watched;
    }

    public MovieDATA(EditText name, EditText year, EditText rating, String wathed) {
        this.name = name.getText().toString();
        this.year = year.getText().toString();
        this.rating = rating.getText().toString();
        this.watched = Boolean.valueOf(wathed);
    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public String getRating() {
        return rating;
    }

    public Boolean getWatched() {
        return watched;
    }
}
