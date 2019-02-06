package com.infisoln.siddhant.listviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

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
                R.layout.list_item_superhero,
                R.id.textView,
                superheroes);

        lvsuperheroes.setAdapter(arrayAdapter);

    }
}
