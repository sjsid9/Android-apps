package com.infisoln.siddhant.roomdatabase_demo;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

public class NotesApplication extends Application {


    static NotesDatabase notesDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
    }


    static NotesDatabase getNotesDatabase(Context context) {
        if (notesDatabase == null) {
            notesDatabase = Room.databaseBuilder(context,
                    NotesDatabase.class,
                    "notesTable.db")
                    .build();
        }
        return notesDatabase;
    }

}
