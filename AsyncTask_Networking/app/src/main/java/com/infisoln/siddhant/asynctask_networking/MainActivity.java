package com.infisoln.siddhant.asynctask_networking;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText = findViewById(R.id.etName);

        Button btnSearch = findViewById(R.id.btnSearch);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyTask myTask = new MyTask();
                myTask.execute("https://api.github.com/search/users?q=" + editText.getText().toString());
            }
        });

    }

    class MyTask extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {

            String inputUrl = strings[0];

            try {

                URL url = new URL(inputUrl);

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                InputStream is = httpURLConnection.getInputStream();

                Scanner scanner = new Scanner(is);
                scanner.useDelimiter("\\A");

                String response = "";

                if (scanner.hasNext()) {
                    response = scanner.next();
                }
                Log.e("TAG", "doInBackground: " + response);
                Log.e("TAG", "doInBackground: " + "Work is going on");

                return response;

            } catch (MalformedURLException e) {
                e.printStackTrace();
                Log.e("TAG", "doInBackground: " + "Malformed URL");
            } catch (IOException e) {
                e.printStackTrace();
                Log.e("TAG", "doInBackground: " + "IO exception");
            }

            return "";
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s) {
            TextView textView = findViewById(R.id.tvResult);
            textView.setText(s);
        }

    }

}
