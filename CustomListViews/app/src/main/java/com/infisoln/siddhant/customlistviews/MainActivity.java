package com.infisoln.siddhant.customlistviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<SuperHero> superheroes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView= findViewById(R.id.listView);

        superheroes.add(new SuperHero("Hulk","Marvel","Smash"));
        superheroes.add(new SuperHero("IronMan","Marvel","Rich"));
        superheroes.add(new SuperHero("BlackWidow","Marvel","Agent"));
        superheroes.add(new SuperHero("Batman","DC","Rich"));
        superheroes.add(new SuperHero("Superman","DC","Superhuman"));
        superheroes.add(new SuperHero("Green Lantern","DC","Magic Ring"));
        superheroes.add(new SuperHero("Flash","DC","superfast"));
        superheroes.add(new SuperHero("Hawkeye","Marvel","Marksman"));
        superheroes.add(new SuperHero("Wolverine","Marvel","Claws"));
        superheroes.add(new SuperHero("Thor","Marvel","God of thunder"));
        superheroes.add(new SuperHero("Kratos","Marvel","God of War"));
        superheroes.add(new SuperHero("Hulk","Marvel","Smash"));
        superheroes.add(new SuperHero("IronMan","Marvel","Rich"));
        superheroes.add(new SuperHero("BlackWidow","Marvel","Agent"));
        superheroes.add(new SuperHero("Batman","DC","Rich"));
        superheroes.add(new SuperHero("Superman","DC","Superhuman"));
        superheroes.add(new SuperHero("Green Lantern","DC","Magic Ring"));
        superheroes.add(new SuperHero("Flash","DC","superfast"));
        superheroes.add(new SuperHero("Hawkeye","Marvel","Marksman"));
        superheroes.add(new SuperHero("Wolverine","Marvel","Claws"));
        superheroes.add(new SuperHero("Thor","Marvel","God of thunder"));
        superheroes.add(new SuperHero("Kratos","Marvel","God of War"));

        SuperHeroAdapter superHeroAdapter= new SuperHeroAdapter(superheroes,this);
        listView.setAdapter(superHeroAdapter);

    }
}
