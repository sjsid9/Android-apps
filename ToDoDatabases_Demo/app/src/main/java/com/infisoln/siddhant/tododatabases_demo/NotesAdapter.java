package com.infisoln.siddhant.tododatabases_demo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesHolder> {

    ArrayList<Note> arrayList;
    NotesDatabaseHelper notesDatabaseHelper;

    public NotesAdapter(ArrayList<Note> arrayList, NotesDatabaseHelper notesDatabaseHelper) {
        this.arrayList = arrayList;
        this.notesDatabaseHelper = notesDatabaseHelper;
    }

    @NonNull
    @Override
    public NotesHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View inflatedView = layoutInflater.inflate(R.layout.layout_row, viewGroup, false);
        return new NotesHolder(inflatedView);

    }

    @Override
    public void onBindViewHolder(@NonNull NotesHolder notesHolder, int i) {

        Note note = arrayList.get(i);

        notesHolder.Note.setText(note.content);
        notesHolder.timeStamp.setText(note.timeStamp);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class NotesHolder extends RecyclerView.ViewHolder {

        TextView Note, timeStamp;
        Button delete;

        public NotesHolder(@NonNull View itemView) {
            super(itemView);
            Note = itemView.findViewById(R.id.tvNote);
            timeStamp = itemView.findViewById(R.id.tvTimeStamp);
            delete = itemView.findViewById(R.id.btnDelete);

            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Note note = arrayList.remove(getAdapterPosition());
                    notesDatabaseHelper.deleteNote(note);
                    notifyDataSetChanged();
                }
            });

        }
    }


}
