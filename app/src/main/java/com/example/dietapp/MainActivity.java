package com.example.dietapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.util.jar.Attributes;


public class MainActivity  extends AppCompatActivity{

    TextView Text;

    Button Fort,BenutzerD;

    Benutzereingabe Benutzer= new Benutzereingabe();

    Datein G = new Datein();
    EditText Edit1,Edit2,Edit3,Edit4;
    private static  final String Name = "Name.txt";
    private static  final String Alter = "Alter.txt";
    private static  final String Große = "Große.txt";
    private static  final String Gewicht = "Gewicht.txt";
    Context context;
    Button FoodI;

    String[] D;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Text = findViewById(R.id.textView6);
        Fort = (Button) findViewById(R.id.Tabelle);
        FoodI = (Button) findViewById(R.id.FoodInfo);
        BenutzerD = findViewById(R.id.Benutzerdaten);



        FoodI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), com.example.dietapp.Optionen.class));
            }
        });

        Fort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), com.example.dietapp.BenutzerInfo.class));
            }
        });

        BenutzerD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), com.example.dietapp.Benutzereingabe.class));
            }
        });





    }

}