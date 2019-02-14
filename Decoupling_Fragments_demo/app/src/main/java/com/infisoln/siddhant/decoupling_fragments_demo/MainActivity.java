package com.infisoln.siddhant.decoupling_fragments_demo;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements Commmunicator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void setTextinDetailAct(String name) {
        FrameLayout frameLayout = findViewById(R.id.container);
        if (frameLayout == null) {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra("Name", name);
            startActivity(intent);
        } else {
//            Bundle bundle = new Bundle();
//            bundle.putString("Name",name);
//            FragmentB fragmentB = new FragmentB();
//            fragmentB.setArguments(bundle);

            // Made the code clear and modular

            Fragment fragmentB = FragmentB.newInstance(name);

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, fragmentB)
                    .commit();
        }
    }
}
