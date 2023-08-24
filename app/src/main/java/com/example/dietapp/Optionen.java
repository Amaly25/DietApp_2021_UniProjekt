package com.example.dietapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class Optionen extends AppCompatActivity {
        Button Manuell;
        Button Scan;
        ListView Liste;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_optionen);

        Manuell = findViewById(R.id.button4);
        Scan = findViewById(R.id.button5);
        Liste = findViewById(R.id.Liste5);


        Manuell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), com.example.dietapp.PEingabe.class));
            }
        });

        Scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), com.example.dietapp.Home.class));
            }
        });

        Datenbank Daten = new Datenbank(Optionen.this);
        List<FoodReportModel> k = Daten.getAllFood();
        Log.d(k.toString(), "onCreate: ");
      if(k != null)
        {  //ArrayAdapter arrayAdapter1 = new ArrayAdapter(Optionen.this, android.R.layout.simple_list_item_1, k);
            AdapterDatei Datei = new AdapterDatei(Optionen.this, k);
            Liste.setAdapter(Datei);
        }else{
          Toast.makeText(this, "Die Liste ist Leer", Toast.LENGTH_SHORT).show();
      }
    }





}