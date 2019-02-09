package com.infisoln.siddhant.notetakingapp;

public class Notes {

    String Note;
    String Time;

    public Notes(String note, String time) {
        Note = note;
        Time = time;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }
}
