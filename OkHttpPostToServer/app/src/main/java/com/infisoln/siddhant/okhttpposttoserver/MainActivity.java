package com.infisoln.siddhant.okhttpposttoserver;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    String url;
    OkHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        url = "https://pokeapi.co/api/v2/pokemon/1";

        makeNetworkCall(url);


    }

    private void makeNetworkCall(String url) {

        client = new OkHttpClient();

        Request request = new Request.Builder().url(url).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String jsonResponse = response.body().string();
                Gson gson = new Gson();
                Result result = gson.fromJson(jsonResponse, Result.class);

                ArrayList<Abilities> abilities = result.getAbilities();

                String abilitiesJson = gson.toJson(abilities);
                postToServer(abilitiesJson);

            }
        });

    }

    private void postToServer(String data) {

        MediaType mediaType = MediaType.parse("application/json");

        RequestBody requestBody = RequestBody.create(mediaType, data);

        Request request = new Request.Builder().
                url("http://ptsv2.com/t/w64hh-1552543690/post").
                post(requestBody).
                build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e("TAG", "onResponse: " + response.body().string());
            }
        });

    }
}
