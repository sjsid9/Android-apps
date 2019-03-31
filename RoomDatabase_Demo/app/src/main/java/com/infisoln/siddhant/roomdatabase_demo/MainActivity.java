package com.infisoln.siddhant.roomdatabase_demo;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final NotesDatabase notesDatabase = NotesApplication
                .getNotesDatabase(getApplicationContext());


        MainActivityViewModel mainActivityViewModel = ViewModelProviders
                .of(this)
                .get(MainActivityViewModel.class);

        LiveData<List<Notes>> liveNotes = mainActivityViewModel.getLiveNotes();

        final List<Notes> originalNotes = new ArrayList<>();

        liveNotes.observe(this, new Observer<List<Notes>>() {
            @Override
            public void onChanged(@Nullable List<Notes> notes) {

                // Set the list to your adapter
                // Notify data change

                notes.removeAll(originalNotes);
                originalNotes.addAll(notes);

                // notify the adapter

            }
        });

//        LiveData<List<Notes>> liveNotes = notesDatabase.getNotesDao().getAllNotes();

//        List<Notes> notes = liveNotes.getValue();


//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                List<Long> ids = notesDatabase.getNotesDao().insertNotes(new Notes("Hello", "World", String.valueOf(System.currentTimeMillis()), true));
//                Log.e(TAG, "run: "+ids.size());
//                Log.e(TAG, "run: "+ids);
//                List<Notes> notesList = notesDatabase.getNotesDao().getAllNotes();
//                Log.e(TAG, "run: " + notesList.get(0).getTitle() + "  " + notesList.get(0).getDescription());
//                Log.e(TAG, "onCreate: " + notesList.size());
//            }
//        }).start();

    }
}
