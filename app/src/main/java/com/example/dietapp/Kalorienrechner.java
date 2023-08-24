package com.example.dietapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

public class Kalorienrechner extends AppCompatActivity {
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalorienrechner);

        text = findViewById(R.id.textView15);


        text.setText(Kalorienberechnen().toString());
    }

    Double Kalorienberechnen(){
        Datenbank db = new Datenbank(Kalorienrechner.this);
        List<PersonDaten> Daten = db.getPersonDatenfurC();
        PersonDaten D = new PersonDaten();
        D = Daten.get(0);

       Double Kalorien = 655.1 + ((Daten.get(0).getGewicht()*9.6)+(1.8*(Daten.get(0).getGroeße()*100))-(4.7*Daten.get(0).getAlter()));
        Log.d(D.toString(), "Kalorienberechnen: ");



        return Kalorien;
    }
}