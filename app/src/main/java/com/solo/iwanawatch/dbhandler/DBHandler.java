package com.solo.iwanawatch.dbhandler;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "iww_db";
    private static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "movies";
    public static final String ID_COL = "id";
    public static final String NAME_COL = "name";
    public static final String YEAR_COL = "year";
    public static final String RATING_COL = "rating";

    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + YEAR_COL + " TEXT,"
                + RATING_COL + " TEXT)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void addNewMovie(String movieName, String movieYear, String movieRating) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME_COL, movieName);
        values.put(YEAR_COL, movieYear);
        values.put(RATING_COL, movieRating);
        db.insert(TABLE_NAME, null, values);
        db.close();
    }
}
