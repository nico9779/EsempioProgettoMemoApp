package com.example.memoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.actions.NoteIntents;

// Activity che mostra le note

public class ActivityNotes extends AppCompatActivity {

    private TextView nota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        nota = findViewById(R.id.textView);
        // ricevo l'intent
        Intent intent = getIntent();
        // verifico se l'intent che ricevo è triggerato dall'assistent
        if(NoteIntents.ACTION_CREATE_NOTE.equals(intent.getAction())) {
            String testo_nota = intent.getStringExtra(Intent.EXTRA_TEXT);
            nota.setText(testo_nota);
        }
        // se non ricevo nessun intent lo segnalo con la textview
        else nota.setText("Non riceve l'intent CREATE_NOTE");
    }
}
