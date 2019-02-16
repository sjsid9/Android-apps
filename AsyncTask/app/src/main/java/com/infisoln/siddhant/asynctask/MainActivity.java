package com.infisoln.siddhant.asynctask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.btn);

        textView = findViewById(R.id.tvTest);

        textView.setText("Count starts");

        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

//                MyTask myTask = new MyTask();
//                myTask.execute(1000000);
                textView.setText("Thread About to start");
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(2000);

                            MainActivity.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    textView.setText("Thread Running");
                                }
                            });
                            Thread.sleep(2000);

                            MainActivity.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    textView.setText("Thread Ran");
                                }
                            });

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                Log.e("TAG", "onClick: counting done");
            }
        });

    }

    class MyTask extends AsyncTask<Integer, Float, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            textView.setText("Counting Starts");
        }

        @Override
        protected String doInBackground(Integer... integers) {
            for (int i = 0; i < integers[0]; i++) {

                if(i%100==0)
                    publishProgress((float) i);
            }
            return "Counting numbers";
        }

        @Override
        protected void onProgressUpdate(Float... values) {
            super.onProgressUpdate(values);
            textView.setText(values[0].toString());
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            textView.setText("Counting done");
        }

    }

}
