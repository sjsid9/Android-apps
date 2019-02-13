package com.infisoln.siddhant.planets_hw;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailActivityFragment extends Fragment {

    String name;
    String description;

    public DetailActivityFragment() {
    }

    public DetailActivityFragment(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.detail_activity_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getActivity().getIntent() != null) {
            Intent i = getActivity().getIntent();

            TextView pname = view.findViewById(R.id.pname);
            TextView pdes = view.findViewById(R.id.pdes);

            if (getActivity().getIntent().hasExtra("PlanetName") && getActivity().getIntent().hasExtra("Description")) {
                String PlanetName = i.getStringExtra("PlanetName");
                String Description = i.getStringExtra("Description");
                pname.setText(PlanetName);
                pdes.setText(Description);
            } else {
                pname.setText(name);
                pdes.setText(description);
            }

        }
    }

}
