package com.codingblocks.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity implements Communicator {

    ArrayList<SuperHero> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        arrayList.add(new SuperHero("Batman", "DC", "Rich"));
        arrayList.add(new SuperHero("Superman", "DC", "Superhuman abilities"));
        arrayList.add(new SuperHero("Captain America", "Marvel", "American"));
        arrayList.add(new SuperHero("Ironman", "Marvel", "Rich"));
        arrayList.add(new SuperHero("Green Lantern", "DC", "Magic Ring"));
        arrayList.add(new SuperHero("Black Widow", "Marvel", "Agent"));
        arrayList.add(new SuperHero("Shazam", "DC", "God's man"));
        arrayList.add(new SuperHero("Hulk", "Marvel", "Smash"));
        arrayList.add(new SuperHero("Batman", "DC", "Rich"));
        arrayList.add(new SuperHero("Superman", "DC", "Superhuman abilities"));
        arrayList.add(new SuperHero("Captain America", "Marvel", "American"));
        arrayList.add(new SuperHero("Ironman", "Marvel", "Rich"));
        arrayList.add(new SuperHero("Green Lantern", "DC", "Magic Ring"));
        arrayList.add(new SuperHero("Black Widow", "Marvel", "Agent"));
        arrayList.add(new SuperHero("Shazam", "DC", "God's man"));
        arrayList.add(new SuperHero("Hulk", "Marvel", "Smash"));

        RecyclerView recyclerView = findViewById(R.id.recyclerView2);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        SuperheroAdapter superheroAdapter = new SuperheroAdapter(arrayList, this);

        recyclerView.setAdapter(superheroAdapter);
    }

    @Override
    public void handleClick(SuperHero superHero) {
        Toast.makeText(this, "" + superHero.getName(), Toast.LENGTH_SHORT).show();
    }
}
