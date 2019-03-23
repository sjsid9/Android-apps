package com.infisoln.siddhant.custombroadcasts;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    MyBroadcastReceiver mbr = new MyBroadcastReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSend = findViewById(R.id.btnSend);
        final EditText etMessage = findViewById(R.id.etMessage);

        IntentFilter inf = new IntentFilter();
        inf.addAction("MyCustomBroadcast");
        inf.addAction(Intent.ACTION_POWER_DISCONNECTED);
        inf.addAction(Intent.ACTION_POWER_CONNECTED);
        inf.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(mbr, inf);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("MyCustomBroadcast");
                intent.putExtra("Message", etMessage.getText().toString());
                sendBroadcast(intent);
            }
        });


    }
}
