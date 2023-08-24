package com.example.dietapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class Benutzereingabe extends AppCompatActivity {
    EditText Edit1,Edit2,Edit3,Edit4;
    Button Kalorien;
    private static  final String Name = "Name.txt";
    private static  final String Alter = "Alter.txt";
    private static  final String Große = "Große.txt";
    private static  final String Gewicht = "Gewicht.txt";
    ListView Liste;
    Button Btn;
    String[] Datein;


    public Benutzereingabe() {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_benutzereingabe);

        Edit1= findViewById(R.id.Edit);
        Edit2= findViewById(R.id.Edit1);
        Edit3= findViewById(R.id.Edit2);
        Edit4 = findViewById(R.id.Edit3);
        Btn = findViewById(R.id.button3);
        Kalorien = findViewById(R.id.button4);


        Kalorien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), com.example.dietapp.Kalorienrechner.class));
            }
        });

        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //Info();

            load();



            }

        });

    }





    public void save(View v) throws IOException {
        String Input = Edit1.getText().toString();
        String Input1 = Edit2.getText().toString();
        String Input2 = Edit3.getText().toString();
        String Input3 = Edit4.getText().toString();
        File file,file2,file3,file4;

        FileOutputStream Datei = null;

        Datenbank db = new Datenbank(Benutzereingabe.this);
        String text=Input+Input1+Input2+Input3;
        Log.d(text, "save: ");
        db.addEinzelDaten(Input,Input1,Input2,Input3);



        try {

            Datei = openFileOutput(Name,MODE_PRIVATE);
                FileOutputStream Datei2 = openFileOutput(Große,MODE_PRIVATE);
                FileOutputStream Datei3 = openFileOutput(Alter,MODE_PRIVATE);
                FileOutputStream Datei4 = openFileOutput(Gewicht,MODE_PRIVATE);

                Datei.write(Input.getBytes());
                Datei2.write(Input1.getBytes());
                Datei3.write(Input2.getBytes());
                Datei4.write(Input3.getBytes());

                Datei.close();
                Datei2.close();
                Datei3.close();
                Datei4.close();


            Toast.makeText(this, "Gespeichert", Toast.LENGTH_SHORT).show();




        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public String[] Info(String Name, String Alter, String Große, String Gewicht) {


        FileInputStream Daten;
        StringBuilder V, a, b, c;


        String[] Datein = new String[4];
        try {
            Datein = null;
            Daten = openFileInput(Name);

            FileInputStream Daten1 = openFileInput(Alter);
            FileInputStream Daten2 = openFileInput(Große);
            FileInputStream Daten3 = openFileInput(Gewicht);


            InputStreamReader data1 = new InputStreamReader(Daten);
            InputStreamReader data2 = new InputStreamReader(Daten1);
            InputStreamReader data3 = new InputStreamReader(Daten2);
            InputStreamReader data4 = new InputStreamReader(Daten3);

            BufferedReader F = new BufferedReader(data1);
            BufferedReader F2 = new BufferedReader(data2);
            BufferedReader F3 = new BufferedReader(data3);
            BufferedReader F4 = new BufferedReader(data4);

            V = new StringBuilder();
            a = new StringBuilder();
            b = new StringBuilder();
            c = new StringBuilder();
            String name = null;
            String alter = null;
            String große = null;
            String gewicht = null;


            while ((name = F.readLine()) != null) {
                V.append(name);

            }
            while ((alter = F2.readLine()) != null) {
                a.append(alter);

            }
            while ((große = F3.readLine()) != null) {
                b.append(große);

            }
            while ((gewicht = F4.readLine()) != null) {
                c.append(gewicht);

            }

            Datein = new String[4];

            this.Datein[0] = V.toString();
            this.Datein[1] = a.toString();
            this.Datein[2] = b.toString();
            this.Datein[3] = c.toString();








        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.getMessage();
            e.printStackTrace();
        }

        Toast.makeText(this, Datein[0], Toast.LENGTH_SHORT).show();

        return Datein;
    }



    void load() {
        Datenbank db = new Datenbank(Benutzereingabe.this);
        Log.d("Reading: ", "Reading all contacts..");
        List<PersonDaten> contacts = db.AllePersonen();
        for (PersonDaten cn : contacts) {
            String log = "Name: " + cn.getName() + " ,Groeße: " +
                    cn.getGroeße()+ ", Alter " + cn.getAlter()+ " ,Gewicht " + cn.getGewicht();
            // Writing Contacts to log
            Log.d("Name: ", log);
        }
    }







    }








