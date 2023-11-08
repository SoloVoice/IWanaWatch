package com.solo.iwanawatch.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.solo.iwanawatch.R;
import com.solo.iwanawatch.data.MovieDATA;
import com.solo.iwanawatch.dbhandler.DBHandler;

public class AddNewMovie extends AppCompatActivity {

    EditText movieName, movieYear, movieRating;
    Button addMovieButton;

    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_movie);

        movieName = findViewById(R.id.editTextMovieName);
        movieYear = findViewById(R.id.editTextMovieYear);
        movieRating = findViewById(R.id.editTextMovieRating);
        dbHandler = new DBHandler(this);

        addMovieButton = findViewById(R.id.addNewMovieButton);
        addMovieButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNewMovie();
            }
        });
    }

    public void addNewMovie() {
        MovieDATA movieDATA = new MovieDATA(
                movieName,
                movieYear,
                movieRating
        );
        dbHandler.createMovie(movieDATA);
        movieName.setText("");
        movieYear.setText("");
        movieRating.setText("");
        startActivity(new Intent(this, MainActivity.class));
    }
}