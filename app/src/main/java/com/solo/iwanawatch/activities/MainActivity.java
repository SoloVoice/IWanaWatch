package com.solo.iwanawatch.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.solo.iwanawatch.R;
import com.solo.iwanawatch.adapter.ListAdapter;
import com.solo.iwanawatch.data.MovieDATA;
import com.solo.iwanawatch.databinding.ActivityMainBinding;
import com.solo.iwanawatch.dbhandler.DBHandler;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ListView listView;
    private Button startGameButton;
    private FloatingActionButton floatingActionButton;
    private DBHandler dbHandler;

    private ArrayList<MovieDATA> movieDATAArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dbHandler = new DBHandler(this);
        movieDATAArrayList = getActiveMoviesList();

        listView = findViewById(R.id.movie_list);

        ListAdapter listAdapter = new ListAdapter(MainActivity.this, movieDATAArrayList);
        binding.movieList.setAdapter(listAdapter);
        binding.movieList.setClickable(true);
        binding.movieList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

//        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, movieArray));

        startGameButton = findViewById(R.id.startGameButton);
        startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveToNextActivity(RandomizerMovie.class, movieDATAArrayList);
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

    public void moveToNextActivity(Class cl, ArrayList<MovieDATA> movieDATAArrayList) {
        Intent intent = new Intent(this, cl);
        intent.putExtra("mA", movieDATAArrayList);
        startActivity(intent);
    }

    private ArrayList<MovieDATA> getActiveMoviesList() {
        return dbHandler.readMovieList();
    }
}