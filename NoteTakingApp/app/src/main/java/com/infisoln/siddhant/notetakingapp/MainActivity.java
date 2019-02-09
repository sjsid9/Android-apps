package com.infisoln.siddhant.notetakingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<Notes> notes  = new ArrayList<>();

        ListView listView = findViewById(R.id.listView);
        final EditText etNote = findViewById(R.id.etNote);
        Button btnAdd = findViewById(R.id.btnAddNote);

        final NotesAdapter notesAdapter = new NotesAdapter(notes,this);
        listView.setAdapter(notesAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String note = etNote.getText().toString();

                String time = String.valueOf(System.currentTimeMillis());

                notes.add(new Notes(note,time));
                notesAdapter.notifyDataSetChanged();
            }
        });

    }
}
