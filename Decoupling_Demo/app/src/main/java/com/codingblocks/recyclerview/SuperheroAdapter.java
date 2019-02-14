package com.codingblocks.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SuperheroAdapter extends RecyclerView.Adapter<SuperheroAdapter.SuperheroHolder> {

    private ArrayList<SuperHero> superHeroes;
    Context ctx;

    Communicator communicator;

    public SuperheroAdapter(ArrayList<SuperHero> superHeroes, Communicator communicator) {
        this.superHeroes = superHeroes;
        this.communicator = communicator;
    }

    @NonNull
    @Override
    public SuperheroHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ctx = viewGroup.getContext();
        LayoutInflater li = LayoutInflater.from(viewGroup.getContext());
        View inflatedView = li.inflate(R.layout.layout_row, viewGroup, false);
        return new SuperheroHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(@NonNull SuperheroHolder superheroHolder, int position) {
        final SuperHero currentHero = superHeroes.get(position);
        superheroHolder.name.setText(currentHero.getName());
        superheroHolder.power.setText(currentHero.getSuperPower());
        superheroHolder.universe.setText(currentHero.getUniverse());
    }

    @Override
    public int getItemCount() {
        return superHeroes.size();
    }

    class SuperheroHolder extends RecyclerView.ViewHolder {

        TextView name, universe, power;

        public SuperheroHolder(@NonNull View view) {
            super(view);
            name = view.findViewById(R.id.superheroName);
            universe = view.findViewById(R.id.superheroUniverse);
            power = view.findViewById(R.id.superheroPower);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SuperHero currentHero = superHeroes.get(getAdapterPosition());
//                    Toast.makeText(ctx, ""+currentHero.getName(), Toast.LENGTH_SHORT).show();
                    communicator.handleClick(currentHero);
                }
            });

        }

    }

}
