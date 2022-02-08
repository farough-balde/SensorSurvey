package com.example.sensorsurvey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity

{

    public static String LOG_TAG = MainActivity.class.getSimpleName();
    private SensorManager mSensorManager;
    private TextView sensorTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState)

    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSensorManager =( SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensorTextView = findViewById(R.id.sensor_list);
        List<Sensor>  sensorList = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        StringBuilder sensorText = new StringBuilder();
        for (Sensor currentSensor : sensorList )
        {
            sensorText.append(currentSensor.getName()).append(System.getProperty("line.separator"));
        }

        sensorTextView.setText(sensorText);
    }


}