package com.demo.sensorexample;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    /*
    STEPS
    1. SENSOR MANAGER
    2. CREATE SENSOR USING SENSORMANAGER
    3. LISTEN SENSOR
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void onClick(View view)
    {
        //1. create sensor manager using sensor service
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        //2. Create Sensor
        Sensor proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        //3. create sensorListener
        sensorManager.registerListener(this, proximitySensor, 1 );

    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        switch (event.sensor.getType())
        {
            case Sensor.TYPE_ACCELEROMETER;
            break;

            case Sensor.TYPE_PROXIMITY;
            break;
        }


        double x = event.values[0];
        double y = event.values[1];
        double z = event.values[2];

        if(x>5 && x<10)
        {
            Toast.makeText(this, "you are too near", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}