package com.infisoln.siddhant.notetakingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class NotesAdapter extends BaseAdapter {

    ArrayList<Notes> notes;
    Context ctx;

    public NotesAdapter(ArrayList<Notes> notes, Context ctx) {
        this.notes = notes;
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return notes.size();
    }

    @Override
    public Notes getItem(int position) {
        return notes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater li =LayoutInflater.from(ctx);
        View inflatedView = li.inflate(R.layout.layout_row,parent,false);

       TextView Note = inflatedView.findViewById(R.id.tvNote);
        TextView time = inflatedView.findViewById(R.id.tvTime);

        Notes currentNote = notes.get(position);

        Note.setText(currentNote.getNote());
        time.setText(currentNote.getTime());

        return  inflatedView;

    }
}
