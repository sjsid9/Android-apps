package com.infisoln.siddhant.sensors_demo;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager sm;
    public static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> list = sm.getSensorList(Sensor.TYPE_ALL);

        Log.e(TAG, "onCreate: " + list.size());

//        for (Sensor s : list) {
//            Log.e(TAG, "onCreate: " + s.toString());
//        }

        Sensor accelerometer = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        Sensor proximity = sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        sm.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_UI);
        sm.registerListener(this, proximity, SensorManager.SENSOR_DELAY_UI);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        float[] sensorValues = event.values;

        switch (event.sensor.getType()) {
            case Sensor.TYPE_ACCELEROMETER:
                Log.e(TAG, "Accelerometer X : " + sensorValues[0]);
                Log.e(TAG, "Accelerometer Y : " + sensorValues[1]);
                Log.e(TAG, "Accelerometer Z : " + sensorValues[2]);
                break;
            case Sensor.TYPE_PROXIMITY:
                Log.e(TAG, "Proximity Sensor : " + sensorValues[0]);
                break;
        }

    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // In case of configuration of device changes
    }

    @Override
    protected void onStop() {
        super.onStop();
        sm.unregisterListener(this);
    }
}
