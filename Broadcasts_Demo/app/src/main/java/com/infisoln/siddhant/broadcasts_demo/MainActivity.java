package com.infisoln.siddhant.broadcasts_demo;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MyBroadcastReceiver mbr = new MyBroadcastReceiver();

        IntentFilter inf = new IntentFilter();
        inf.addAction(Intent.ACTION_POWER_CONNECTED);
        inf.addAction(Intent.ACTION_POWER_DISCONNECTED);
        inf.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);

        registerReceiver(mbr,inf);

    }
}
