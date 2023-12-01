package com.solo.iwanawatch.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import com.solo.iwanawatch.R;
import com.solo.iwanawatch.data.MovieDATA;
import com.solo.iwanawatch.databinding.ActivityRamdomizerMovieBinding;
import com.solo.iwanawatch.dbhandler.DBHandler;

import java.util.ArrayList;

public class RandomizerMovie extends AppCompatActivity {

    ActivityRamdomizerMovieBinding binding;
    private ArrayList<MovieDATA> movieDATAArrayList;
    private TextView showMovie, randomTimer;
    DBHandler dbHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRamdomizerMovieBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dbHandler = new DBHandler(this);

        Bundle arguments = getIntent().getExtras();
        movieDATAArrayList = dbHandler.readMovieList();
//        movieDATAArrayList = (ArrayList<MovieDATA>) arguments.get("mA");

        showMovie = findViewById(R.id.assignMovie);
        randomTimer = findViewById(R.id.randomTimer);

        pickRandomMovie(movieDATAArrayList);
    }

    private void pickRandomMovie(ArrayList<MovieDATA> movieDATAArrayList) {
        double d = Math.random();
        int i = (int) Math.round(d*movieDATAArrayList.size());
        showMovie.setText(movieDATAArrayList.get(i).getName());
        startTimer();
    }

    private void startTimer() {
        new CountDownTimer(5000, 1000) {
            int timer = 5;
            @Override
            public void onTick(long l) {
                randomTimer.setText(String.valueOf(timer--));
            }
            public void onFinish() {
                back();
            }
        }.start();
    }

    private void back() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}