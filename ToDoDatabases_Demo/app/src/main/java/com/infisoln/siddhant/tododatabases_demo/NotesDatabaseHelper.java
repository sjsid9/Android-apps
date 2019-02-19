package com.infisoln.siddhant.tododatabases_demo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class NotesDatabaseHelper extends SQLiteOpenHelper {

    public NotesDatabaseHelper(Context context) {
        super(context,"notesDB",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE todo_table(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "title TEXT NOT NULL," +
                "content TEXT NOT NULL," +
                "timeStamp TEXT NOT NULL," +
                "isDone INTEGER );");
    }

    public Long insertNote(Note note) {

        ContentValues contentValues = new ContentValues();

        contentValues.put("title", note.getTitle());
        contentValues.put("content", note.getContent());
        contentValues.put("timeStamp", note.getTimeStamp());
        contentValues.put("isDone", note.getIsDone());

        long id = getWritableDatabase().insert("todo_table", null, contentValues);

        return id;

    }

    public void updateNote(Note note) {

        ContentValues contentValues = new ContentValues();

        contentValues.put("title", note.getTitle());
        contentValues.put("content", note.getContent());
        contentValues.put("timeStamp", note.getTimeStamp());
        contentValues.put("isDone", note.getIsDone());


        getWritableDatabase().update("todo_table",
                contentValues,
                "id = ?",
                new String[]{String.valueOf(note.getId())});

    }

    public void deleteNote(Note note) {
        getWritableDatabase().delete("todo_table",
                "id = ?",
                new String[]{String.valueOf(note.getId())});
    }

    public ArrayList<Note> getAllNotes() {

        ArrayList<Note> arrayList = new ArrayList<>();

        Cursor c = getReadableDatabase().query("todo_table",
                null,
                null,
                null,
                null,
                null,
                "timeStamp DESC");

        while (c.moveToNext()) {

            Integer id = c.getInt(0);
            String title = c.getString(1);
            String content = c.getString(c.getColumnIndex("content"));
            String timeStamp = c.getString(c.getColumnIndex("timeStamp"));
            Integer isDone = c.getInt(c.getColumnIndex("isDone"));

            Note note = new Note(title, content, timeStamp, isDone, id);
            arrayList.add(note);

        }
        c.close();
        return arrayList;

    }


    public Note getNoteById(Long id) {

        Note note = null;
        Cursor c = getReadableDatabase().query("todo_table",
                null,
                null,
                null,
                null,
                null,
                "timeStamp DESC");


        if (c.moveToNext()) {
            int noteId = c.getInt(0);
            String title = c.getString(1);
            String content = c.getString(c.getColumnIndex("content"));
            String timeStamp = c.getString(c.getColumnIndex("timeStamp"));
            int isDone = c.getInt(c.getColumnIndex("isDone"));

            note = new Note(title, content, timeStamp, isDone, noteId);

        }
        c.close();
        return note;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
