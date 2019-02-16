package com.infisoln.siddhant.asynctask;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
        textView.setText("Count starts");
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (long i = 1; i < 10; i+=1) {
                            if (i % 1 == 0) {
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
                Log.e("TAG", "onClick: counting done");
                textView.setText("Counting done");
            }
        });

    }
}
