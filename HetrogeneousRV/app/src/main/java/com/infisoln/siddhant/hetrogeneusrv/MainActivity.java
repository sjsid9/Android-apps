package com.infisoln.siddhant.hetrogeneusrv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Object> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayList.add(new TextClass("Hello1", "World1"));
        arrayList.add(new ImageClass("Hello1", "World1", "https://randomuser.me/api/portraits/women/32.jpg"));
        arrayList.add(new TextClass("Hello2", "World2"));
        arrayList.add(new ImageClass("Hello1", "World1", "https://randomuser.me/api/portraits/women/52.jpg"));
        arrayList.add(new ImageClass("Hello1", "World1", "https://randomuser.me/api/portraits/women/72.jpg"));
        arrayList.add(new ImageClass("Hello1", "World1", "https://randomuser.me/api/portraits/women/12.jpg"));

        arrayList.add(new TextClass("Hello3", "World3"));
        arrayList.add(new ImageClass("Hello1", "World1", "https://randomuser.me/api/portraits/women/25.jpg"));
        arrayList.add(new TextClass("Hello4", "World4"));
        arrayList.add(new ImageClass("Hello1", "World1", "https://randomuser.me/api/portraits/women/34.jpg"));
        arrayList.add(new TextClass("Hello5", "World5"));
        arrayList.add(new ImageClass("Hello1", "World1", "https://randomuser.me/api/portraits/women/28.jpg"));
        arrayList.add(new TextClass("Hello6", "World6"));
        arrayList.add(new TextClass("Hello7", "World7"));
        arrayList.add(new ImageClass("Hello1", "World1", "https://randomuser.me/api/portraits/women/22.jpg"));

        arrayList.add(new TextClass("Hello8", "World8"));
        arrayList.add(new TextClass("Hello9", "World9"));
        arrayList.add(new ImageClass("Hello1", "World1", "https://randomuser.me/api/portraits/women/14.jpg"));
        arrayList.add(new ImageClass("Hello1", "World1", "https://randomuser.me/api/portraits/women/18.jpg"));
        arrayList.add(new TextClass("Hello10", "World10"));
        arrayList.add(new TextClass("Hello11", "World11"));
        arrayList.add(new ImageClass("Hello1", "World1", "https://randomuser.me/api/portraits/women/15.jpg"));
        arrayList.add(new ImageClass("Hello1", "World1", "https://randomuser.me/api/portraits/women/23.jpg"));
        arrayList.add(new TextClass("Hello12", "World12"));
        arrayList.add(new ImageClass("Hello1", "World1", "https://randomuser.me/api/portraits/women/31.jpg"));

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        HetrogeneousAdapter hetrogeneousAdapter = new HetrogeneousAdapter(arrayList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(hetrogeneousAdapter);


    }
}
