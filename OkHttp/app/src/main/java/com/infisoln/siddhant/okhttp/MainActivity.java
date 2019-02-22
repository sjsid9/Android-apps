package com.infisoln.siddhant.okhttp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText = findViewById(R.id.etName);
        Button btnSearch = findViewById(R.id.btnSearch);

        textView = findViewById(R.id.tvResult);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeNetworkCall(editText.getText().toString());
            }
        });


    }

    private void makeNetworkCall(String s) {

        OkHttpClient client = new OkHttpClient();

        final Request request = new Request.Builder()
                .url("https://api.github.com/search/users?q=" + s)
                .build();


        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

//
//                if (count < 3) {
//                    count++;
//                    call.enqueue(this);
//                }

                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "Error in Network Call" + "\n" + "Please Retry", Toast.LENGTH_SHORT).show();
                    }
                });

                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                final String result = response.body().string();

                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(result);
                    }
                });
            }
        });

    }
}
