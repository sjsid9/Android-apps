package com.infisoln.siddhant.location_demo;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LocationListener {

    public static final String TAG = "TAG";
    LocationManager lm;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPermission = findViewById(R.id.btncontactPermission);

        btnPermission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (PackageManager.PERMISSION_GRANTED == ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_CONTACTS)) {

                } else {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_CONTACTS}, 420);
                }
            }
        });

        lm = (LocationManager) getSystemService(LOCATION_SERVICE);

        if (PackageManager.PERMISSION_GRANTED == ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)) {

            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 10, this);

        } else {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, 12345);
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case 420:
                // handle call

                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "PERMISSION GRANTED", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "PERMISSION DENIED", Toast.LENGTH_SHORT).show();
                }


                break;
            case 12345:
                // handle location
                Toast.makeText(this, "LOCATION GRANTED", Toast.LENGTH_SHORT).show();
                break;
        }

    }

    @Override
    public void onLocationChanged(Location location) {

        Log.e(TAG, "Provider: " + location.getProvider());
        Log.e(TAG, "Accuracy: " + location.getAccuracy());
        Log.e(TAG, "Altitude: " + location.getAltitude());
        Log.e(TAG, "Latitude: " + location.getLatitude());
        Log.e(TAG, "Longitude: " + location.getLongitude());
        Log.e(TAG, "Bearing: " + location.getBearing());
        Log.e(TAG, "Speed: " + location.getSpeed());
        Log.e(TAG, "Time: " + location.getTime());

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

}
