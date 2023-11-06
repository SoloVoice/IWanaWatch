package com.solo.iwanawatch.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ProgressBar;

import com.solo.iwanawatch.R;
import com.solo.iwanawatch.activities.MainActivity;

public class WelcomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);
        Intent intent = new Intent(this, MainActivity.class);
        ProgressBar progressBar = findViewById(R.id.welcomePageProgressBar);
        new CountDownTimer(10000, 1000) {
            int pr = 0;
            @Override
            public void onTick(long l) {
                progressBar.setProgress(pr);
                pr += 12;
            }
            public void onFinish() {
                startActivity(intent);
            }
        }.start();
    }
}