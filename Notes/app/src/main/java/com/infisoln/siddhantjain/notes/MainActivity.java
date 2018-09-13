
package com.infisoln.siddhantjain.notes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ArrayList<Notes> notes = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText noteTitle=findViewById(R.id.etNoteTitle);

        ListView listView= findViewById(R.id.listView);
        final NotesAdapter notesAdapter= new NotesAdapter(notes);

        listView.setAdapter(notesAdapter);

        Button btnAdd= findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title=noteTitle.getText().toString();

                Calendar calendar=Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());

                DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

                String t=formatter.format(calendar.getTime());

//                String time= String.valueOf(System.currentTimeMillis());
                Notes note = new Notes(title,t);

                notes.add(note);
                notesAdapter.notifyDataSetChanged();
            }
        });

    }
}
