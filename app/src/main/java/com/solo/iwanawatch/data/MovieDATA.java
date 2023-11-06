package com.solo.iwanawatch.data;

import lombok.Data;

@Data
public class MovieDATA {
    private String name;
    private String year;
    private String rating;

    public MovieDATA(String s, String s1, String s2) {
        name = s;
        year = s1;
        rating = s2;
    }
}
