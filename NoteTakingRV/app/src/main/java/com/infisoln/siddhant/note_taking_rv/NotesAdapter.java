package com.infisoln.siddhant.note_taking_rv;

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

    public NotesAdapter(ArrayList<Note> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public NotesHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater li = LayoutInflater.from(viewGroup.getContext());
        View view = li.inflate(R.layout.layout_row, viewGroup, false);
        return new NotesHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesHolder notesHolder, int i) {
        Note currentNote = arrayList.get(i);
        notesHolder.note.setText(currentNote.getTitle());
        notesHolder.time.setText(currentNote.getTime());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class NotesHolder extends RecyclerView.ViewHolder {
        TextView note, time;

        public NotesHolder(@NonNull View itemView) {
            super(itemView);

            Button btnDelete = itemView.findViewById(R.id.btnDelete);
            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    arrayList.remove(getAdapterPosition());
                    notifyDataSetChanged();
                }
            });
            note = itemView.findViewById(R.id.tvNote);
            time = itemView.findViewById(R.id.tvTime);
        }
    }

}
