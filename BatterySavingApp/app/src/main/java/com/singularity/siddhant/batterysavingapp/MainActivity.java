package com.singularity.siddhant.batterysavingapp;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    MyBroadcastReciever mbr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mbr= new MyBroadcastReciever(this);
        IntentFilter inf = new IntentFilter();
        inf.addAction(Intent.ACTION_POWER_CONNECTED);
        inf.addAction(Intent.ACTION_POWER_DISCONNECTED);
        inf.addAction(Intent.ACTION_BATTERY_LOW);
        registerReceiver(mbr,inf);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mbr);
    }
}
