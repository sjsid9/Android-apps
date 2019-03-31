package com.infisoln.siddhant.roomdatabase_demo;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Notes.class,User.class}, version = 1)
public abstract class NotesDatabase extends RoomDatabase {

    public abstract NotesDao getNotesDao();

    public abstract UsersDao getUsersDao();

}