package com.infisoln.siddhant.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<SuperHero> superHeroes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        superHeroes.add(new SuperHero("Batman", "DC", "Rich"));
        superHeroes.add(new SuperHero("Aquaman", "DC", "king of sea"));
        superHeroes.add(new SuperHero("Black Widow", "Marvel", "Agent"));
        superHeroes.add(new SuperHero("Iron Man", "MArvel", "Genius"));
        superHeroes.add(new SuperHero("Hulk", "Marvel", "Smash"));
        superHeroes.add(new SuperHero("Thor", "Marvel", "god of thunder"));
        superHeroes.add(new SuperHero("Flash", "DC", "Metahuman"));
        superHeroes.add(new SuperHero("Superman", "DC", "Superhuman"));
        superHeroes.add(new SuperHero("Cyborg", "DC", "Robot"));
        superHeroes.add(new SuperHero("Hawkeye", "Marvel", "Marksman"));
        superHeroes.add(new SuperHero("Dr.Manhattan", "DC", "SuperStrong"));
        superHeroes.add(new SuperHero("Shazam", "DC", "God's Man"));
        superHeroes.add(new SuperHero("Batgirl", "DC", "mind"));
        superHeroes.add(new SuperHero("Aquaman", "DC", "king of sea"));
        superHeroes.add(new SuperHero("Black Widow", "Marvel", "Agent"));
        superHeroes.add(new SuperHero("Iron Man", "MArvel", "Genius"));
        superHeroes.add(new SuperHero("Hulk", "Marvel", "Smash"));
        superHeroes.add(new SuperHero("Thor", "Marvel", "god of thunder"));
        superHeroes.add(new SuperHero("Flash", "DC", "Metahuman"));
        superHeroes.add(new SuperHero("Superman", "DC", "Superhuman"));
        superHeroes.add(new SuperHero("Cyborg", "DC", "Robot"));
        superHeroes.add(new SuperHero("Hawkeye", "Marvel", "Marksman"));
        superHeroes.add(new SuperHero("Dr.Manhattan", "DC", "SuperStrong"));
        superHeroes.add(new SuperHero("Shazam", "DC", "God's Man"));
        superHeroes.add(new SuperHero("Batgirl", "DC", "mind"));
        superHeroes.add(new SuperHero("Aquaman", "DC", "king of sea"));
        superHeroes.add(new SuperHero("Black Widow", "Marvel", "Agent"));
        superHeroes.add(new SuperHero("Iron Man", "MArvel", "Genius"));
        superHeroes.add(new SuperHero("Hulk", "Marvel", "Smash"));
        superHeroes.add(new SuperHero("Thor", "Marvel", "god of thunder"));
        superHeroes.add(new SuperHero("Flash", "DC", "Metahuman"));
        superHeroes.add(new SuperHero("Superman", "DC", "Superhuman"));
        superHeroes.add(new SuperHero("Cyborg", "DC", "Robot"));
        superHeroes.add(new SuperHero("Hawkeye", "Marvel", "Marksman"));
        superHeroes.add(new SuperHero("Dr.Manhattan", "DC", "SuperStrong"));
        superHeroes.add(new SuperHero("Shazam", "DC", "God's Man"));
        superHeroes.add(new SuperHero("Batgirl", "DC", "mind"));
        superHeroes.add(new SuperHero("Aquaman", "DC", "king of sea"));
        superHeroes.add(new SuperHero("Black Widow", "Marvel", "Agent"));
        superHeroes.add(new SuperHero("Iron Man", "MArvel", "Genius"));
        superHeroes.add(new SuperHero("Hulk", "Marvel", "Smash"));
        superHeroes.add(new SuperHero("Thor", "Marvel", "god of thunder"));
        superHeroes.add(new SuperHero("Flash", "DC", "Metahuman"));
        superHeroes.add(new SuperHero("Superman", "DC", "Superhuman"));
        superHeroes.add(new SuperHero("Cyborg", "DC", "Robot"));
        superHeroes.add(new SuperHero("Hawkeye", "Marvel", "Marksman"));
        superHeroes.add(new SuperHero("Dr.Manhattan", "DC", "SuperStrong"));
        superHeroes.add(new SuperHero("Shazam", "DC", "God's Man"));
        superHeroes.add(new SuperHero("Batgirl", "DC", "mind"));


        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        SuperHeroAdapter superHeroAdapter = new SuperHeroAdapter(superHeroes);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(superHeroAdapter);

    }
}
