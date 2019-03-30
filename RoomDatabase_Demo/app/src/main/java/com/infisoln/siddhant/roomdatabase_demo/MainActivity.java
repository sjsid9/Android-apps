package com.infisoln.siddhant.roomdatabase_demo;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final NotesDatabase notesDatabase = Room.databaseBuilder(this,
                NotesDatabase.class,
                "notesTable.db")
                .build();

        new Thread(new Runnable() {
            @Override
            public void run() {
                notesDatabase.getNotesDao().insertNotes(new Notes("Hello", "World", String.valueOf(System.currentTimeMillis()), true));
                List<Notes> notesList = notesDatabase.getNotesDao().getAllNotes();
                Log.e(TAG, "run: " + notesList.get(0).getTitle() + "  " + notesList.get(0).getDescription());
                Log.e(TAG, "onCreate: " + notesList.size());
            }
        }).start();

    }
}
