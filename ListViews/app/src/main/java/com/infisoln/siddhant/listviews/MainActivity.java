package com.infisoln.siddhant.listviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] superheroes={"Captain America","Iron Man","Black Widow","SpiderMan",
                "Aquaman","Goku","Shaktiman","Hulk","Batman","Wonder Woman",
        "Vegeta","Picolo","gohan","Hawkeye","Scarlet Witch","Magneto","Flash","Superman","Professor X"};

        ListView lvsuperheroes = findViewById(R.id.lvSuperheroes);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                superheroes);

        lvsuperheroes.setAdapter(arrayAdapter);

    }
}
