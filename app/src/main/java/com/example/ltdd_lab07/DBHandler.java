package com.example.ltdd_lab07;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.ltdd_lab07.model.People;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "personDB";
    private static final String TABLE_PEOPLE = "person";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_PEOPLE + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_NAME + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PEOPLE);

        onCreate(db);
    }

    void addPeople(People people) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, people.getName()); // Contact Name

        // Inserting Row
        db.insert(TABLE_PEOPLE, null, values);
        db.close(); // Closing database connection
    }

    public List<People> getPeoples(){
        List<People> peopleList = new ArrayList<>();

        String query ="SELECT * FROM "+TABLE_PEOPLE;

        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query,null);

        if (cursor.moveToFirst()){
            do{
                People people = new People();
                people.setId(Integer.parseInt(cursor.getString(0)));
                people.setName(cursor.getString(1));
            }while (cursor.moveToNext());
        }

        return peopleList;
    }
}
