package com.infisoln.siddhant.customlistviews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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
        View inflatedView;
        ViewHolder viewHolder;

        if(convertView == null){
            inflatedView = li.inflate(R.layout.layout_row,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.initialize(inflatedView);
//            viewHolder.name = inflatedView.findViewById(R.id.SuperHeroName);
//            viewHolder.universe = inflatedView.findViewById(R.id.SuperHeroUniverse);
//            viewHolder.power = inflatedView.findViewById(R.id.SuperHeroPower);
            inflatedView.setTag(viewHolder);
        }else{
            inflatedView = convertView;
            viewHolder = (ViewHolder) inflatedView.getTag();
        }

        SuperHero currentHero = arrayList.get(position);

        viewHolder.name.setText(currentHero.getName());
        viewHolder.universe.setText(currentHero.getUniverse());
        viewHolder.power.setText(currentHero.getPower());

        return inflatedView;

    }


    class ViewHolder{
        TextView name,universe,power;

        void initialize(View view){
            name = view.findViewById(R.id.SuperHeroName);
            universe = view.findViewById(R.id.SuperHeroUniverse);
            power = view.findViewById(R.id.SuperHeroPower);
        }

    }

}
