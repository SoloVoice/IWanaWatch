package com.solo.iwanawatch.data;

import lombok.Getter;
import lombok.Setter;

public class MovieDATA {
    private String name;
    private String year;
    private String rating;

    public MovieDATA(String s, String s1, String s2) {
        name = s;
        year = s1;
        rating = s2;
    }

    public void setName(String s) {
        name = s;
    }

    public void setYear(String s) {
        year = s;
    }

    public void setRating(String s) {
        rating = s;
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
