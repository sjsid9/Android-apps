package com.infisoln.siddhant.asynctask_networking;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    ArrayList<Item> responseArrayList = new ArrayList<>();

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


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("KEY", responseArrayList);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        responseArrayList = savedInstanceState.getParcelableArrayList("KEY");
        GithubAdapter githubAdapter = new GithubAdapter(responseArrayList);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setAdapter(githubAdapter);
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

            responseArrayList = parseJson(s);
            GithubAdapter githubAdapter = new GithubAdapter(responseArrayList);
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            recyclerView.setAdapter(githubAdapter);

        }

    }

    private ArrayList<Item> parseJson(String s) {

        ArrayList<Item> itemArrayList = new ArrayList<>();

        try {
            JSONObject rootObject = new JSONObject(s);

            JSONArray itemsArray = rootObject.getJSONArray("items");

            for (int i = 0; i < itemsArray.length(); i++) {
                JSONObject currentObject = itemsArray.getJSONObject(i);
                String login = currentObject.getString("login");
                String id = currentObject.getString("id");
                String avatar_url = currentObject.getString("avatar_url");
                String url = currentObject.getString("url");
                String score = currentObject.getString("score");

                Item item = new Item(login, id, avatar_url, url, score);
                itemArrayList.add(item);

            }

            return itemArrayList;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return itemArrayList;

    }

}
