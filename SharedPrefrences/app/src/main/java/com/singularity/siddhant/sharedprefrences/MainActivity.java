package com.singularity.siddhant.sharedprefrences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int count = 0;
    TextView tvCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnIncrement = findViewById(R.id.btnIncrement),
                btnDecrement = findViewById(R.id.btnDecrement);

        btnIncrement.setOnClickListener(this);
        btnDecrement.setOnClickListener(this);

        tvCount = findViewById(R.id.tvCount);

        SharedPreferences sharedPreferences = getSharedPreferences("myprefs", MODE_PRIVATE);
        count = sharedPreferences.getInt("COUNT", 0);
        tvCount.setText(String.valueOf(count));
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnIncrement:
                count++;
                break;
            case R.id.btnDecrement:
                count--;
                break;
        }
        tvCount.setText(String.valueOf(count));
    }

    @Override
    protected void onStop() {
        SharedPreferences sharedPreferences = getSharedPreferences("myprefs", MODE_PRIVATE);
        final SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt("COUNT", count);
        edit.apply();
        super.onStop();
    }
}