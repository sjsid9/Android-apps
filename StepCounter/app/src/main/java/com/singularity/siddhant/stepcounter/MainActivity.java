package com.singularity.siddhant.stepcounter;

import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    public static final String TAG="MAINACTIVITY";
    SensorManager sm;
    TextView tvCount;
    Sensor stepDetector;
    Sensor stepCounter;

    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCount=findViewById(R.id.tvCount);

        final SharedPreferences sharedPreferences = getSharedPreferences("myprefs",MODE_PRIVATE);
        count=sharedPreferences.getInt("COUNT",0);
        tvCount.setText(String.valueOf(count));


        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        Button btnStart = findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sm.registerListener(MainActivity.this,stepDetector,SensorManager.SENSOR_DELAY_UI);
                sm.registerListener(MainActivity.this,stepCounter,SensorManager.SENSOR_DELAY_UI);
            }
        });

        Button btnReset = findViewById(R.id.btnReset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final SharedPreferences.Editor edit = sharedPreferences.edit();
                count=0;
                edit.putInt("COUNT",count);
                tvCount.setText(String.valueOf(count));
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        stepDetector = sm.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);
        stepCounter = sm.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        float []sensorValues=sensorEvent.values;

        switch (sensorEvent.sensor.getType()){

            case Sensor.TYPE_STEP_DETECTOR:
                if(sensorValues[0]==1.0){
                    Log.e(TAG, "Step Detector : "+sensorValues[0]);
                    count++;
                    tvCount.setText(String.valueOf(count));
                    break;
                }

        }


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onStop() {
        SharedPreferences sharedPreferences = getSharedPreferences("myprefs",MODE_PRIVATE);
        final SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt("COUNT",count);
        edit.apply();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sm.unregisterListener(MainActivity.this);
    }
}
