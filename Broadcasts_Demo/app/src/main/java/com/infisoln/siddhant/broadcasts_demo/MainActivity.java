package com.infisoln.siddhant.broadcasts_demo;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    MyBroadcastReceiver mbr = new MyBroadcastReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnStart = findViewById(R.id.btnStart);
        Button btnStop = findViewById(R.id.btnStop);


        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentFilter inf = new IntentFilter();
                inf.addAction(Intent.ACTION_POWER_CONNECTED);
                inf.addAction(Intent.ACTION_POWER_DISCONNECTED);
                inf.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);

                registerReceiver(mbr, inf);

            }
        });


        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unregisterReceiver(mbr);
            }
        });

    }
}
