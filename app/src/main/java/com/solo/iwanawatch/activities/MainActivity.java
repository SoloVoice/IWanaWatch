package com.solo.iwanawatch.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.solo.iwanawatch.R;
import com.solo.iwanawatch.data.MovieDATA;
import com.solo.iwanawatch.dbhandler.DBHandler;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private Button startGameButton;
    private FloatingActionButton floatingActionButton;
    private DBHandler dbHandler;

    private String[] movieArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHandler = new DBHandler(this);

        movieArray = ass();

        listView = findViewById(R.id.movie_list);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, movieArray));

        startGameButton = findViewById(R.id.startGameButton);
        startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveToNextActivity(RamdomizerMovie.class, movieArray);
            }
        });

        floatingActionButton = findViewById(R.id.openAddNewMovieActivityButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveToNextActivity(AddNewMovie.class);
            }
        });
    }

    public void moveToNextActivity(Class cl) {
        Intent intent = new Intent(this, cl);
        startActivity(intent);
    }

    public void moveToNextActivity(Class cl, String[] stringsArray) {
        Intent intent = new Intent(this, cl);
        intent.putExtra("mA", movieArray);
        startActivity(intent);
    }

    private String[] ass() {
        ArrayList<MovieDATA> movieDATAArrayList = dbHandler.readMovieList();
        String a[] = new String[movieDATAArrayList.size()];
        for (int i = 0; i < a.length; i++) {
            MovieDATA md = movieDATAArrayList.get(i);
            a[i] = md.getName();
        }
        return a;
    }
}