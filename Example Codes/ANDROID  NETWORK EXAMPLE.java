package com.demo.androidnetworkexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    // STEPS
    //1. Permissions (in android manifest)
    //e.g Internet, networkState (jitne chahye utne)
    // 2. CREATE A THREAD
    //3. CREATE A URL
    //4. CREATE A CONNECTION USING URL (openURLConnection)
    //5. Reading or Writing data using HTTPUrlConnection


    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TEXT VIEW
         textView = findViewById(R.id.tv_1);

         //THREAD CREATION STEP 2
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //PASSING URL TO OUR USER DEFINED FUNCTION
                readData("http://www.google.com");
            }
        })     ;

        //STARTING THREADD
        thread.start();


    }



    //OUR USER DEFINDED FUNCTION TO GET DATA FROM INTERNET
    void readData(String _urlSring)
     {
         //STEP 3 CREATE A URL
        URL url = null;
        //STEP 4 CREATE A CONNECTION
        HttpURLConnection connection = null;

        try {
            //STEP 3 CONTINUE
            url = new URL(_urlSring);
            //STEP 4 CONTINUE
            connection = (HttpURLConnection) url.openConnection();

            //STEP 5 READ AND WRITE DATA USING HTTPUrlConnection
            final InputStream inputStream = connection.getInputStream();

            //PRINTING DATA ON TEXT VIEW
            textView.post(new Runnable() {
                @Override
                public void run() {
                    try {
                        textView.setText(inputStream.read() + "");
                        }
                    catch (Exception ex)
                    {
                    }
                                }});

        }catch (Exception _exception)
        {

        }finally {
            connection.disconnect();
        }

    }

}