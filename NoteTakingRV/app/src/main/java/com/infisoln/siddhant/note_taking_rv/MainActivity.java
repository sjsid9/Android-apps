package com.infisoln.siddhant.note_taking_rv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Note> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText = findViewById(R.id.etNote);
        Button btnAdd = findViewById(R.id.btnAdd);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        final NotesAdapter notesAdapter = new NotesAdapter(arrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(notesAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList.add(new Note(editText.getText().toString(), "" + System.currentTimeMillis()));
                notesAdapter.notifyDataSetChanged();
            }
        });


    }
}
