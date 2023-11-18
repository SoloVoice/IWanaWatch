package com.solo.iwanawatch.dbhandler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.solo.iwanawatch.data.MovieDATA;

import java.util.ArrayList;
import java.util.function.ToDoubleBiFunction;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "iww_db";
    private static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "movies";
    public static final String ID_COL = "id";
    public static final String NAME_COL = "name";
    public static final String YEAR_COL = "year";
    public static final String RATING_COL = "rating";
    public static final String WATCHED_COL = "watched";

    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + YEAR_COL + " TEXT,"
                + RATING_COL + " TEXT,"
                + WATCHED_COL + " TEXT)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void createMovie(MovieDATA movieDATA) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME_COL, movieDATA.getName());
        values.put(YEAR_COL, movieDATA.getYear());
        values.put(RATING_COL, movieDATA.getRating());
        values.put(WATCHED_COL, movieDATA.getWatched().toString());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public ArrayList<MovieDATA> readMovieList() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        ArrayList<MovieDATA> movieDATAArrayList = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                movieDATAArrayList.add(
                        new MovieDATA(
                                cursor.getString(1),
                                cursor.getString(2),
                                cursor.getString(3),
                                Boolean.valueOf(cursor.getString(4))
                        ));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return movieDATAArrayList;
    }

    //TODO: Сделать добавление нового атрибута, для определения был ли фильм просмотрен или нет.
    public void updateMovie(MovieDATA movieDATA) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME_COL, movieDATA.getName());
        values.put(YEAR_COL, movieDATA.getYear());
        values.put(RATING_COL, movieDATA.getRating());
        values.put(WATCHED_COL, movieDATA.getWatched().toString());
        db.update(TABLE_NAME, values, "NAME =" + movieDATA.getName(), null);
        db.close();
    }

    public void deleteMovie(MovieDATA movieDATA) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        db.delete(TABLE_NAME, NAME_COL + "=" + movieDATA.getName(), new String[]{});
        db.close();
    }
}
