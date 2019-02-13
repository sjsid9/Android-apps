package com.infisoln.siddhant.planets_hw;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.PlanetHolder> {

    private ArrayList<Planet> planetArrayList;
    Context ctx;

    PlanetAdapter(ArrayList<Planet> planetArrayList, Context ctx) {
        this.planetArrayList = planetArrayList;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public PlanetHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        ctx = viewGroup.getContext();
        LayoutInflater li = LayoutInflater.from(viewGroup.getContext());
        View view = li.inflate(R.layout.layout_row, viewGroup, false);
        return new PlanetHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetHolder planetHolder, int i) {

        Planet currentPlanet = planetArrayList.get(i);
        planetHolder.planetName.setText(currentPlanet.getPlanetName());
        Picasso.get().load(currentPlanet.getPlanetUrl()).into(planetHolder.planetImage);

    }

    @Override
    public int getItemCount() {
        return planetArrayList.size();
    }

    class PlanetHolder extends RecyclerView.ViewHolder {

        TextView planetName;
        ImageView planetImage;

        PlanetHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Planet currentPlanet = planetArrayList.get(getAdapterPosition());
                    Intent i = new Intent(ctx, PlanetDetailActivity.class);
                    i.putExtra("PlanetName", currentPlanet.getPlanetName());
                    i.putExtra("Description", currentPlanet.getPlanetDescription());
                    ctx.startActivity(i);
                }
            });

            planetName = itemView.findViewById(R.id.tvPlanetName);
            planetImage = itemView.findViewById(R.id.ivPlanetImage);
        }

    }

}
