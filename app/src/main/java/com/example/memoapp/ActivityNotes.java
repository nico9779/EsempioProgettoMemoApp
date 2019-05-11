package com.example.memoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
        // ricevo l'intent dalla main activity
        else if(getCallingActivity().getClassName().equals("com.example.memoapp.MainActivity"))
            nota.setText("Activity triggerata dal main");
        // non ricevo nessun intent
        else nota.setText("Errore");
    }

    // metodo che mi fa tornare nell'activity precedente
    public void backButton(View view) {
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        finish();
    }
}
