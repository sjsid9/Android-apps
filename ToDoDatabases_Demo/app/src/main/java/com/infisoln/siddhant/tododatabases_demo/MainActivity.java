package com.infisoln.siddhant.tododatabases_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final NotesDatabaseHelper notesDatabaseHelper = new NotesDatabaseHelper(this);
        final ArrayList<Note> arrayList = notesDatabaseHelper.getAllNotes();
        final NotesAdapter notesAdapter = new NotesAdapter(arrayList, notesDatabaseHelper);

        final EditText etNote = findViewById(R.id.etNote);
        Button btnAdd = findViewById(R.id.btnAddNote);


        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(notesAdapter);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long id = notesDatabaseHelper.insertNote(new Note("MyNotes",
                        etNote.getText().toString(),
                        "" + System.currentTimeMillis(), 1));

                Note note = notesDatabaseHelper.getNoteById(id);
                arrayList.add(note);
                notesAdapter.notifyDataSetChanged();

            }
        });


//        Note note = new Note("Hello", "First Enry", "35151515", 0);
//        notesDatabaseHelper.insertNote(note);
//        Log.e("TAG", "onCreate: " + arrayList.size());
//        Log.e(TAG, "onCreate: " + note.getId());

    }
}
