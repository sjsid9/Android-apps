package com.infisoln.siddhant.listviews_fragments_demo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivityFragment extends Fragment {
    ArrayList<Superhero> superHeroes = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        superHeroes.add(new Superhero("Batman", "DC", "Rich"));
        superHeroes.add(new Superhero("IronMan", "Marvel", "Rich"));
        superHeroes.add(new Superhero("Captain America", "Marvel", "American"));
        superHeroes.add(new Superhero("Superman", "DC", "Superhuman abilities"));
        superHeroes.add(new Superhero("Hulk", "Marvel", "Smash"));
        superHeroes.add(new Superhero("Aquaman", "DC", "King of sea"));
        superHeroes.add(new Superhero("Shazam", "DC", "God's Man"));
        superHeroes.add(new Superhero("Black Widow", "Marvel", "Agent"));
        superHeroes.add(new Superhero("Wonder Woman", "DC", "Metahuman"));
        superHeroes.add(new Superhero("Cyborg", "DC", "Robot"));

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_activity_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SuperHeroAdapter superHeroAdapter = new SuperHeroAdapter(superHeroes, view.getContext());

        ListView listView = view.findViewById(R.id.listView);
        listView.setAdapter(superHeroAdapter);
    }

}
