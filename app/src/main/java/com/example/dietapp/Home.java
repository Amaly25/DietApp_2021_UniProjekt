package com.example.dietapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;

import java.util.List;


public class Home  extends AppCompatActivity{



    Button button,button2,button3;
    public static EditText Input;
    ListView Liste;
    TextView txt,Zucker,Fett,Kalorien,Protein,ZuckerA,FettA,KalA,ProteinA;
    ImageView Image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        Input = findViewById(R.id.Input);
        txt = findViewById(R.id.inp);
        Zucker = findViewById(R.id.ZuckerZ);
        Kalorien = findViewById(R.id.KalZ);
        Protein = findViewById(R.id.ProteinZ);
        Fett = findViewById(R.id.FettZ);
        ZuckerA = findViewById(R.id.ZuckerA);
        KalA = findViewById(R.id.KalA);
        ProteinA = findViewById(R.id.ProteinA);
        FettA = findViewById(R.id.FettA);


        FoodDataService Food = new FoodDataService(Home.this);
        FoodReportModel F = new FoodReportModel();
        Image =(ImageView) findViewById(R.id.imageView);
        //Funktionen damit beim klicken etwas passiert

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // Instantiate the RequestQueue.
                String Bild="image_url";
                String Name = "product_name";
                Food.getName(Input.getText().toString(),Bild,Name, new FoodDataService.FoodData() {
                    @Override
                    public void onError(String message) {
                        Toast.makeText(Home.this, "Kaputt", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(List<FoodReportModel> Info) {
                        Toast.makeText(Home.this, "Return Something:"+ Info.get(0).getBild().toString(), Toast.LENGTH_SHORT).show();



                            txt.setText(Info.get(0).getName());
                        Glide.with(Home.this).load(Info.get(0).getBild()).into(Image);




                    }
                });


                //Toast.makeText(MainActivity.this, "Du hast aufmich gedrückt 1", Toast.LENGTH_SHORT).show();

                Food.FoodInfo(Input.getText().toString(), new FoodDataService.FoodData() {
                    @Override
                    public void onError(String message) {
                        Toast.makeText(Home.this, "Kaputt", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(List<FoodReportModel> Info) {
                        Toast.makeText(Home.this, Info.toString(), Toast.LENGTH_SHORT).show();


                        Double Zucker1 = Info.get(0).getZucker();
                        Double Fett1 = Info.get(0).getFat();
                        Double Proteine = Info.get(0).getProtein();
                        Double Kalorien1 = Info.get(0).getKalorien();

                        ZuckerA.setText("Zucker:");
                        KalA.setText("Kalorien:");
                        ProteinA.setText("Protein:");
                        FettA.setText("Fett:");

                        Zucker.setText(Zucker1.toString());
                        Fett.setText(Fett1.toString());
                        Protein.setText(Proteine.toString());
                        Kalorien.setText(Kalorien1.toString());
                        //datenbank prozess fängt hier an
                        Datenbank DB1= new Datenbank(Home.this);
                        FoodReportModel Produkt = new FoodReportModel(Info.get(0).getZucker(),
                                Info.get(0).getKalorien(),
                                Info.get(0).getFat(),
                                Info.get(0).getProtein(),
                                Info.get(0).getName(),
                                Info.get(0).getBild());

                        DB1.addFood(Produkt);

                           Log.d("Reading: ", "Reading all contacts..");
        List<FoodReportModel> contacts = DB1.getAllFood();
                              for (FoodReportModel cn : contacts) {
            String log = "Id: " + cn.getId() + " ,Fat: " + cn.getFat() + " ,Kalorien: " +
                    cn.getKalorien()+ ", Protein " + cn.getProtein() + " Sugar: " + cn.getZucker();
            // Writing Contacts to log
            Log.d("Name: ", log);
        }


                    }
                });



            }
        });


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ScanBarcode.class));
            }
        });


    }

}