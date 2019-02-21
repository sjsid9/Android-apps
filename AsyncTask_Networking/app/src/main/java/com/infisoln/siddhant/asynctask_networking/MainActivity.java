package com.infisoln.siddhant.asynctask_networking;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyTask myTask = new MyTask();
        myTask.execute("https://wwww.google.com");
    }

    ProgressDialog progressDialog;

    class MyTask extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setTitle("Downloading");
            progressDialog.setMessage("Fetching content");
            progressDialog.setMax(100);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... strings) {
            try {

                while (progressDialog.getProgress() <= progressDialog.getMax()) {
                    Thread.sleep(200);
                    progressDialog.incrementProgressBy(1);
                    if (progressDialog.getProgress() == progressDialog.getMax()) {
                        progressDialog.dismiss();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progressDialog.dismiss();
        }

    }

}
