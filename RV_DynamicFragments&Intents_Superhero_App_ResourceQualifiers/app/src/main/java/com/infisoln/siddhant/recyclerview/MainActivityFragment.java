package com.infisoln.siddhant.recyclerview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MainActivityFragment extends Fragment {

    ArrayList<SuperHero> superHeroes = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_activity_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        SuperHeroAdapter superHeroAdapter = new SuperHeroAdapter(superHeroes, (AppCompatActivity) getActivity());

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        recyclerView.setAdapter(superHeroAdapter);
    }

}
