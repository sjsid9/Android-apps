package com.infisoln.siddhant.recyclerview;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class SuperHeroAdapter extends RecyclerView.Adapter<SuperHeroAdapter.SuperHeroHolder> {


    ArrayList<SuperHero> superHeroes;
    AppCompatActivity appCompatActivity;

    public SuperHeroAdapter(ArrayList<SuperHero> superHeroes, AppCompatActivity activity) {
        this.superHeroes = superHeroes;
        this.appCompatActivity = activity;
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
        superHeroHolder.universe.setText(currentSuperHero.getSuperHeroUniverse());
        superHeroHolder.power.setText(currentSuperHero.getSuperHeroUniverse());

    }

    @Override
    public int getItemCount() {
        return superHeroes.size();
    }

    class SuperHeroHolder extends RecyclerView.ViewHolder {
        TextView name, universe, power;

        public SuperHeroHolder(@NonNull final View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SuperHero currentSuperhero = superHeroes.get(getAdapterPosition());

                    if (appCompatActivity.findViewById(R.id.container) == null) {
                        startIntent(currentSuperhero.getSuperHeroName());
                    } else {
                        addFragment(currentSuperhero.getSuperHeroName());
                    }

                }
            });
            name = view.findViewById(R.id.tvName);
            universe = view.findViewById(R.id.tvUniverse);
            power = view.findViewById(R.id.tvPOwer);
        }
    }


    void startIntent(String name) {
        Intent intent = new Intent(appCompatActivity.getBaseContext(), DetailActivity.class);
        intent.putExtra("Name", name);
        appCompatActivity.getBaseContext().startActivity(intent);
    }

    void addFragment(String name) {

        FragmentManager fm = appCompatActivity.getSupportFragmentManager();
        fm.beginTransaction()
                .replace(R.id.container, new DetailActivityFragment())
                .add(R.id.container, new DetailActivityFragment(name))
                .commit();

    }
}
