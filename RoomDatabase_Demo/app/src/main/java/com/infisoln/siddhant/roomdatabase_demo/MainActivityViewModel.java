package com.infisoln.siddhant.roomdatabase_demo;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    private LiveData<List<Notes>> liveNotes;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Notes>> getLiveNotes() {

        NotesDao notesDao = NotesApplication
                .getNotesDatabase(getApplication())
                .getNotesDao();

        liveNotes = notesDao.getAllNotes();

        return liveNotes;
    }
}
