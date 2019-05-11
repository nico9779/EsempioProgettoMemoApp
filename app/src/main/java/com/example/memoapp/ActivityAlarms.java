package com.example.memoapp;

import android.app.VoiceInteractor;
import android.content.Intent;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
        // verifico se l'intent che ricevo è triggerato dall'assistent per impostare una sveglia
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
        // verifico se l'intent che ricevo è triggerato dall'assistent per vedere tutte le mie sveglie
        else if(AlarmClock.ACTION_SHOW_ALARMS.equals(intent.getAction()))
            allarme.setText("Ho triggerato questa Activity chiedendo di mostrarmi gli allarmi");
        // ricevo l'intent dalla main activity
        else if(getCallingActivity().getClassName().equals("com.example.memoapp.MainActivity"))
            allarme.setText("Activity triggerata dal main");
        // non ricevo nessun intent
        else allarme.setText("Errore");
    }

    // metodo che mi fa tornare nell'activity precedente
    public void backButton(View view) {
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        finish();
    }
}
