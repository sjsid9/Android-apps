package com.infisoln.siddhant.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class SuperHeroAdapter extends RecyclerView.Adapter<SuperHeroAdapter.SuperHeroHolder> {


    ArrayList<SuperHero> superHeroes;

    public SuperHeroAdapter(ArrayList<SuperHero> superHeroes) {
        this.superHeroes = superHeroes;
    }

    View inflatedView;

    @NonNull
    @Override
    public SuperHeroHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater li = LayoutInflater.from(viewGroup.getContext());

        inflatedView = li.inflate(R.layout.layout_row, viewGroup, false);
        return new SuperHeroHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(@NonNull SuperHeroHolder superHeroHolder, int i) {

        SuperHero currentSuperHero = superHeroes.get(i);
        superHeroHolder.name.setText(currentSuperHero.getSuperHeroName());
        superHeroHolder.universe.setText(currentSuperHero.superHeroUniverse);
        superHeroHolder.power.setText(currentSuperHero.getSuperHeroUniverse());

    }

    @Override
    public int getItemCount() {
        return superHeroes.size();
    }

    class SuperHeroHolder extends RecyclerView.ViewHolder {
        TextView name, universe, power;

        public SuperHeroHolder(@NonNull View view) {
            super(view);
            name = view.findViewById(R.id.tvName);
            universe = view.findViewById(R.id.tvUniverse);
            power = view.findViewById(R.id.tvPOwer);
        }
    }

}
