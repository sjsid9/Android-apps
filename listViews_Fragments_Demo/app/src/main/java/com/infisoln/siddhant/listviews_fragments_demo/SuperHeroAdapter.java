package com.infisoln.siddhant.listviews_fragments_demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SuperHeroAdapter extends BaseAdapter {

    ArrayList<Superhero> superheroes;
    Context ctx;

    public SuperHeroAdapter(ArrayList<Superhero> superheroes, Context ctx) {
        this.superheroes = superheroes;
        this.ctx = ctx;
    }


    @Override
    public int getCount() {
        return superheroes.size();
    }

    @Override
    public Superhero getItem(int position) {
        return superheroes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        LayoutInflater li = LayoutInflater.from(ctx);
        View inflatedView = layoutInflater.inflate(R.layout.layout_row, parent, false);

        TextView name = inflatedView.findViewById(R.id.superHeroName);
        TextView universe = inflatedView.findViewById(R.id.universe);
        TextView superPower = inflatedView.findViewById(R.id.superPower);

        Superhero currentSuperHero = superheroes.get(position);
        name.setText(currentSuperHero.getSuperHeroName());
        universe.setText(currentSuperHero.getUniverse());
        superPower.setText(currentSuperHero.getSuperPower());

        return inflatedView;

    }

}
