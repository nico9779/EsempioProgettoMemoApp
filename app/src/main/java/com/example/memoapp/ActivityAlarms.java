package com.example.memoapp;

import android.app.VoiceInteractor;
import android.content.Intent;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

// Activity che mostra gli allarmi

public class ActivityAlarms extends AppCompatActivity {

    private TextView allarme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarms);
        allarme = findViewById(R.id.textView);
        // ricevo l'intent
        Intent intent = getIntent();
        // verifico se l'intent che ricevo è triggerato dall'assistent
        if(AlarmClock.ACTION_SET_ALARM.equals(intent.getAction())){
            // verifico se ci sono gli extra che mi servono per impostare la sveglia
            if(intent.hasExtra(AlarmClock.EXTRA_HOUR) && intent.hasExtra(AlarmClock.EXTRA_MINUTES)) {
                String ore = Integer.toString(intent.getIntExtra(AlarmClock.EXTRA_HOUR,-1));
                String minuti = Integer.toString(intent.getIntExtra(AlarmClock.EXTRA_MINUTES,-1));
                /* se imposto un'orario con i minuti 00 tipo 21:00 o 22:00 l'intent EXTRA_MINUTES riceve 0
                   quindi risolvo questo problema con un if
                 */
                if(minuti.equals("0"))
                    allarme.setText(ore+":"+"00");
                else allarme.setText(ore+":"+minuti);
            }
            // se non ricevo nessun extra lo segnalo con la textview
            else allarme.setText("Non ci sono gli extra");
        }
        // se non ricevo nessun intent lo segnalo con la textview
        else allarme.setText("Non funziona");
    }
}
