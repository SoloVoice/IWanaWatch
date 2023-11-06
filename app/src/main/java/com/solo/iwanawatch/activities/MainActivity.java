package com.solo.iwanawatch.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.solo.iwanawatch.R;
import com.solo.iwanawatch.dbhandler.DBHandler;

public class MainActivity extends AppCompatActivity {

    String[] movieList  = new String[] {
            "Старикам Тут Не Место",
            "Звездные Войны 6",
            "Пираты Карибского Моря",
            "Назад В Будущее",
            "Полицейская Академия",
            "Доспехи Бога",
            "Звездный Десант",
            "Бегущмий По Лезвию",
            "Амели",
            "Доктор Кто",
            "Убийство В Восточном Экспресе",
            "Джанго",
            "Супермен",
            "Полицейская История",
            "Бойцовский Клуб",
            "Калина Красная",
            "Иван Васильевич Меняет Профессию",
            "Гарри Поттер",
            "Алладин",
            "Корпорация Монстров",
            "Карты Деньги Два Ствола"
    };
    private ListView listView;
    private FloatingActionButton floatingActionButton;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.movie_list);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, movieList));

        floatingActionButton = findViewById(R.id.openAddNewMovieActivityButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNewMovieActivity();
            }
        });
        dbHandler = new DBHandler(this);
        dbHandler.getMovieList();
    }

    public void addNewMovieActivity() {
        Intent intent = new Intent(this, AddNewMovie.class);
        startActivity(intent);
    }


}