package com.infisoln.siddhant.broadcasts_demo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        switch (intent.getAction()) {
            case Intent.ACTION_POWER_CONNECTED:
                Toast.makeText(context, "Power Connected", Toast.LENGTH_SHORT).show();
                break;
            case Intent.ACTION_POWER_DISCONNECTED:
                Toast.makeText(context, "Power Disconnected", Toast.LENGTH_SHORT).show();
                break;
            case Intent.ACTION_AIRPLANE_MODE_CHANGED:
                Toast.makeText(context, "Airplane Mode Toogled", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
