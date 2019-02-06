package com.infisoln.siddhant.listviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<String> superheroes = new ArrayList<>(Arrays.asList("Captain America", "Iron Man", "Black Widow", "SpiderMan",
                "Aquaman", "Goku", "Shaktiman", "Hulk", "Batman", "Wonder Woman",
                "Vegeta", "Picolo", "gohan", "Hawkeye", "Scarlet Witch", "Magneto", "Flash", "Superman", "Professor X"));

//        String[] superheroes={"Captain America","Iron Man","Black Widow","SpiderMan",
//                "Aquaman","Goku","Shaktiman","Hulk","Batman","Wonder Woman",
//        "Vegeta","Picolo","gohan","Hawkeye","Scarlet Witch","Magneto","Flash","Superman","Professor X"};

        ListView lvsuperheroes = findViewById(R.id.lvSuperheroes);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
                R.layout.list_item_superhero,
                R.id.textView,
                superheroes);

        lvsuperheroes.setAdapter(arrayAdapter);


        Button btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newSuperHero = ((EditText)findViewById(R.id.etSuperheroName)).getText().toString();
                Log.d("TAG",""+superheroes.size());
                superheroes.add(newSuperHero);
                Log.d("TAG",""+superheroes.size());
            }
        });

        arrayAdapter.notifyDataSetChanged();
    }
}
