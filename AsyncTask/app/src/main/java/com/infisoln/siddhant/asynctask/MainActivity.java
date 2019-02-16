package com.infisoln.siddhant.asynctask;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.btn);
        final TextView textView = findViewById(R.id.tvTest);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (long i = 0; i < 1000000000000L; i++) {
                            if (i % 1000 == 0) {
                                final long finalI1 = i;
                                MainActivity.this.runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        textView.setText(String.valueOf(finalI1));
                                    }
                                });
                            }
                        }
                    }
                }).start();


            }
        });

    }
}
