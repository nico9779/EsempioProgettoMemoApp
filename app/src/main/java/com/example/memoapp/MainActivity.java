package com.example.memoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.concurrent.Future;

// Activity principale

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // metodo che triggera l'activity che mostra le sveglie
    public void openActivitySveglie(View view) {
        Intent intent = new Intent(this, ActivityAlarms.class);
        startActivityForResult(intent,0);
    }

    // metodo che triggera l'activity che mostra le note
    public void openActivityNote(View view) {
        Intent intent = new Intent(this, ActivityNotes.class);
        startActivityForResult(intent,0);
    }
}
