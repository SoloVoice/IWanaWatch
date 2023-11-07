package com.solo.iwanawatch.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.solo.iwanawatch.R;

public class RamdomizerMovie extends AppCompatActivity {

    private String[] movieArray;
    private Button randomizeButton;
    private TextView showMovie, randomTimer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ramdomizer_movie);

        Bundle arguments = getIntent().getExtras();
        movieArray = (String[]) arguments.get("mA");

        randomizeButton = findViewById(R.id.goWatchMovieButton);
        randomizeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                randomMovie(movieArray);
            }
        });

        showMovie = findViewById(R.id.assignMovie);
        randomTimer = findViewById(R.id.randomTimer);
    }

    private void randomMovie(String[] s) {
        double d = Math.random();
        int i = (int) Math.round(d*s.length);
        showMovie.setText(s[i]);
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