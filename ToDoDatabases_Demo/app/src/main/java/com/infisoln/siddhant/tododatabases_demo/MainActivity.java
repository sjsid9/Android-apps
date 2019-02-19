package com.infisoln.siddhant.tododatabases_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NotesDatabaseHelper notesDatabaseHelper = new NotesDatabaseHelper(this);

        Note note = new Note("Hello", "First Enry", "35151515", 0);

        notesDatabaseHelper.insertNote(note);

        ArrayList<Note> arrayList = notesDatabaseHelper.getAllNotes();

        Log.e("TAG", "onCreate: " + arrayList.size());

        Log.e(TAG, "onCreate: " + note.getId());

    }
}
