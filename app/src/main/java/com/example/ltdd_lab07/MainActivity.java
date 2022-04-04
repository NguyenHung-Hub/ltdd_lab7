package com.example.ltdd_lab07;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.ltdd_lab07.model.People;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DBHandler db=new DBHandler(this);

        db.addPeople(new People(1,"Nguyen Hung 1"));
        db.addPeople(new People(2,"Nguyen Hung 2"));
        db.addPeople(new People(3,"Nguyen Hung 3"));
        db.addPeople(new People(4,"Nguyen Hung 4"));
    }
}