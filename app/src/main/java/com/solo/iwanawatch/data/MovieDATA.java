package com.solo.iwanawatch.data;

import android.widget.EditText;

import lombok.Getter;
import lombok.Setter;

public class MovieDATA {
    private String name;
    private String year;
    private String rating;

    public MovieDATA(String name, String year, String rating) {
        this.name = name;
        this.year = year;
        this.rating = rating;
    }

    public MovieDATA(EditText name, EditText year, EditText rating) {
        this.name = name.getText().toString();
        this.year = year.getText().toString();
        this.rating = rating.getText().toString();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setRating(String rating) {
        this.rating = rating;
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
}
