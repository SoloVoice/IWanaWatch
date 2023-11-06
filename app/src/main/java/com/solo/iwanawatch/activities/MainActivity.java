package com.solo.iwanawatch.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.solo.iwanawatch.R;

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
            "Иван Васильевич Меняет Профессию"
    };
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.movie_list);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, movieList));
    }


}