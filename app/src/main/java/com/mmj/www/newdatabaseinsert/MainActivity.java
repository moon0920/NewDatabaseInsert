package com.mmj.www.newdatabaseinsert;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    MyDBOpenHelper dbHelper;
    SQLiteDatabase mdb;
    String country,city;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new MyDBOpenHelper(this,"awe.db",null,1);
        mdb = dbHelper.getWritableDatabase();
        Button mbtninsert = findViewById(R.id.mbtninsert);
        mbtninsert.setOnClickListener(this);
        Button mbtnreaddata = findViewById(R.id.mbtnreaddata);
        mbtnreaddata.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        EditText medcontry = findViewById(R.id.medcontry);
        EditText medcity = findViewById(R.id.medcity);
        TextView mtvresult = findViewById(R.id.mtvresult);
        country = medcontry.getText().toString();
        city = medcity.getText().toString();

        String query = "SELECT * FROM awe_country";
        Cursor cursor = mdb.rawQuery(query, null);
        String str = "";

        int id1 = view.getId();
        int id;
        switch (id1){
            case R.id.mbtninsert:// 입력하기
                mdb.execSQL("INSERT INTO awe_country VALUES (null,'"+country+"','"+city+"');");
                medcontry.setText("");
                medcity.setText("");
                break;
            case R.id.mbtnreaddata:// 화면에 출력하기
                while(cursor.moveToNext()){
                    id = cursor.getInt(0);
                    country = cursor.getString(cursor.getColumnIndex("country"));
                    city = cursor.getString(2);
                    str += (id + "/ country : " + country + " / city : " + city + "\n");
                    mtvresult.setText(str);
                }
                break;
        }






    }
}
