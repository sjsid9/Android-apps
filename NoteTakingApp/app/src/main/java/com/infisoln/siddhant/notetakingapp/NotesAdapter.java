package com.infisoln.siddhant.notetakingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater li = LayoutInflater.from(ctx);

        View inflatedView;
        ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            inflatedView = li.inflate(R.layout.layout_row, parent, false);
            viewHolder.initialize(inflatedView);
            inflatedView.setTag(viewHolder);
//            viewHolder.Note = inflatedView.findViewById(R.id.tvNote);
//            viewHolder.time = inflatedView.findViewById(R.id.tvTime);
        } else {
            inflatedView = convertView;
            viewHolder = (ViewHolder) inflatedView.getTag();
        }

        Button btnDelete = inflatedView.findViewById(R.id.btnDelete);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notes.remove(position);
                notifyDataSetChanged();
            }
        });

        Notes currentNote = notes.get(position);

        viewHolder.Note.setText(currentNote.getNote());
        viewHolder.time.setText(currentNote.getTime());

        return inflatedView;

    }

    class ViewHolder {
        TextView Note, time;

        void initialize(View view) {
            Note = view.findViewById(R.id.tvNote);
            time = view.findViewById(R.id.tvTime);
        }

    }

}
