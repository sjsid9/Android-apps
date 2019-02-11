package com.infisoln.siddhant.planets_hw;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class PlanetDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet_detail);

        if(getIntent()!=null){
            Intent i = getIntent();
            String PlanetName = i.getStringExtra("PlanetName");
            String Description = i.getStringExtra("Description");

            TextView pname = findViewById(R.id.pname);
            TextView pdes = findViewById(R.id.pdes);
            pname.setText(PlanetName);
            pdes.setText(Description);

        }
    }
}
