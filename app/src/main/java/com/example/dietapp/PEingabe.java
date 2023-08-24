package com.example.dietapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class PEingabe extends AppCompatActivity {
    EditText ed,ed2,ed3,ed4;
    TextView textView;
    Button btn;
    TextView textView2;
    Button btn2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_eingabe);
        ed = findViewById(R.id.Ed);
        ed2 = findViewById(R.id.Ed2);
        ed3 = findViewById(R.id.Ed3);
        ed4 = findViewById(R.id.Ed4);

        btn = findViewById(R.id.button6);
        btn2=findViewById(R.id.button7);
        textView = findViewById(R.id.textView7);
        textView2 = findViewById(R.id.textView8);




    }

    public void save(View v) throws IOException {
        String Input = ed.getText().toString();
        String Input1 = ed2.getText().toString();
        String Input2 = ed3.getText().toString();
        String Input3 = ed4.getText().toString();

        Datenbank db = new Datenbank(PEingabe.this);

        db.EFood(Input,Input1,Input2,Input3);

        Log.d("Reading: ", "Reading all contacts..");
        List<FoodReportModel> contacts = db.getAllFood();
        for (FoodReportModel cn : contacts) {
            String log = "Id: " + cn.getId() + " ,Fat: " + cn.getFat() + " ,Kalorien: " +
                    cn.getKalorien()+ ", Protein " + cn.getProtein() + " Sugar: " + cn.getZucker();
            // Writing Contacts to log
            Log.d("Name: ", log);
        }

    }


    public void load(View v) throws IOException {
        FileInputStream file = openFileInput("Produkt.txt");
        InputStreamReader S = new InputStreamReader(file);
        BufferedReader B  = new BufferedReader(S);
        StringBuilder SB = new StringBuilder();
        String Text;

        while ((Text = B.readLine())!=null){
            SB.append(Text);
        }

        textView2.setText(SB);


    }




}