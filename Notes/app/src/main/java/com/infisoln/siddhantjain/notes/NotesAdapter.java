package com.infisoln.siddhantjain.notes;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class NotesAdapter extends BaseAdapter{

   private ArrayList<Notes> note ;

    NotesAdapter(ArrayList<Notes> note) {
        this.note = note;
    }

    @Override
    public int getCount() {
        return note.size();
    }

    @Override
    public Notes getItem(int position) {
        return note.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater li = LayoutInflater.from(parent.getContext());
        View inflatedView;

        Log.e("TAG","getView"+convertView);

        if(convertView==null)
            inflatedView=li.inflate(R.layout.item_row,parent,false);
        else
            inflatedView=convertView;


//        Notes currentNote = note.get(position);
        Notes currentNote= getItem(position);

        TextView noteTitle,noteTime;
        noteTitle=inflatedView.findViewById(R.id.textViewTitle);
        noteTime=inflatedView.findViewById(R.id.textViewTime);

        Button btnDelete= inflatedView.findViewById(R.id.btnDelete);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                note.remove(position);
                notifyDataSetChanged();
            }
        });

        noteTitle.setText(currentNote.getTitle());
        noteTime.setText(currentNote.getTime());

        return inflatedView;

    }
}
