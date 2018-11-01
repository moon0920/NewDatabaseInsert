package com.mmj.www.newdatabaseinsert;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    MyDBOpenHelper dbHelper;
    SQLiteDatabase mdb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new MyDBOpenHelper(this,"awe.db",null,1);
        mdb = dbHelper.getWritableDatabase();
    }

    @Override
    public void onClick(View view) {
        EditText medcontry = findViewById(R.id.medcontry);
        EditText medcity = findViewById(R.id.medcity);
        String contry = medcontry.getText().toString();
        String city = medcity.getText().toString();

        mdb.execSQL("INSERT INTO awe_contry VALUES (null,'"+contry+"','"+city+"');");
    }
}
