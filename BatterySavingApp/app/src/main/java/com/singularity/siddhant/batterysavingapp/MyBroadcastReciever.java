package com.singularity.siddhant.batterysavingapp;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

public class MyBroadcastReciever extends BroadcastReceiver {


    private Context contextnew;
    public MyBroadcastReciever (Context contextpassed) {
        this.contextnew = contextpassed;
    }

    @Override
    public void onReceive(Context context, Intent intent) {

//        PendingResult pr = goAsync();
//
//        pr.finish();
        switch (intent.getAction()){

            case Intent.ACTION_POWER_CONNECTED:
                contextnew.startActivity(new Intent(contextnew,ChargingActivity.class));
                break;
            case Intent.ACTION_POWER_DISCONNECTED :
                contextnew.startActivity(new Intent(contextnew,DischargingActivity.class));
                break;
            case Intent.ACTION_BATTERY_LOW :
                Intent i = new Intent();
//                i.setAction(Settings.ACTION_BATTERY_SAVER_SETTINGS);
                i.setAction(Intent.ACTION_POWER_USAGE_SUMMARY);
                contextnew.startActivity(i);
                break;
        }

    }
}
