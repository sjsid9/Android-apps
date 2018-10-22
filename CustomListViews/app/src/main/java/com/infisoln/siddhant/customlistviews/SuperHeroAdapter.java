package com.infisoln.siddhant.customlistviews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SuperHeroAdapter extends BaseAdapter {

    ArrayList<SuperHero> arrayList;
    Context ctx;
    public SuperHeroAdapter(ArrayList<SuperHero> arrayList,Context context) {
        this.arrayList = arrayList;
        this.ctx=context;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public SuperHero getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater li = LayoutInflater.from(ctx);
        View inflatedView=li.inflate(R.layout.layout_row,parent,false);

        SuperHero currentHero = arrayList.get(position);

        TextView name=inflatedView.findViewById(R.id.SuperHeroName);
        TextView universe=inflatedView.findViewById(R.id.SuperHeroUniverse);
        TextView power=inflatedView.findViewById(R.id.SuperHeroPower);

        name.setText(currentHero.getName());
        universe.setText(currentHero.getUniverse());
        power.setText(currentHero.getPower());

        return inflatedView;

    }
}
