package com.practise.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creating database NAMED 'Users'
        SQLiteDatabase myDatabase = this.openOrCreateDatabase
                ("Users", MODE_PRIVATE, null);

        //CREATING TABLE WITH COLOUMNS NAME AND AGE
        myDatabase.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR, age INT(3))");

        //INSERTING A ROW INTO TABLE
        myDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Bilal', 24)");

        //INSERTING A ROW INTO TABLE
        myDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Haider', 34)");


        //THIS WAS HOW WE INSERT DATA
        //NOW WE WILL SEE HOW TO PULL DATA
        // FOR PULLING DATA CURSOR IS USED

        //CURSOR
        Cursor c= myDatabase.rawQuery("SELECT * FROM users", null);

        //GETING INDEX FOR COLOUMN name AND age
        int nameIndex = c.getColumnIndex("name");
        int ageIndex = c.getColumnIndex("age");

        //MOVE CURSOR TO START POSITION ( FIRST ROW)
        c.moveToFirst();

        //ITERATING THROUGH TABLE
        while(c != null)
        {
            Log.i("name", c.getString(nameIndex));
            Log.i("name", c.getString(nameIndex));

            //MOVE CURSOR TO NEXT LINE
            c.moveToFirst();
        }


    }
}
