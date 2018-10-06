package com.singularity.siddhant.sensors;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager sm;
    public static final String TAG="MAINACTIVITY";
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sm= (SensorManager) getSystemService(SENSOR_SERVICE);

        List<Sensor> sensors =sm.getSensorList(Sensor.TYPE_ALL);

        Log.e(TAG, "Number of Sensors "+sensors.size() );

        for(Sensor s:sensors){
            Log.e(TAG, ":"+s.toString());
        }

        constraintLayout=findViewById(R.id.rootLayout);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Sensor acclerometer = sm.getDefaultSensor(Sensor.TYPE_GRAVITY);
        Sensor proximity = sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        sm.registerListener(this,acclerometer,SensorManager.SENSOR_DELAY_UI);
        sm.registerListener(this,proximity,SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        float []sensorValues =sensorEvent.values;

        switch (sensorEvent.sensor.getType()){
            case Sensor.TYPE_GRAVITY:
//                Log.e(TAG, "Gravity in x : "+sensorValues[0] );
//                Log.e(TAG, "Gravity in y : "+sensorValues[1] );
//                Log.e(TAG, "Gravity in z : "+sensorValues[2] );
                int a = (int) ((sensorValues[0]/9.8)*255);
                int b = (int) ((sensorValues[1]/9.8)*255);
                int c = (int) ((sensorValues[2]/9.8)*255);

                int color = Color.rgb(a,b,c);
                constraintLayout.setBackgroundColor(color);
                break;
            case Sensor.TYPE_PROXIMITY:
//                Log.e(TAG, "Proximity Distance : "+sensorValues[0] );
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onStop() {
        super.onStop();
        sm.unregisterListener(this);
    }
}
