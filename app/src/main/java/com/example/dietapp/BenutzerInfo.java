package com.example.dietapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;
import java.util.List;

public class BenutzerInfo extends AppCompatActivity {

    LineChart Graph;
    Datenbank db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_benutzer_info);

        Graph = findViewById(R.id.GewichtInfo);

        TextView Name = findViewById(R.id.NameI);
        TextView Große = findViewById(R.id.GroeßeI);
        TextView Alter = findViewById(R.id.AlterI);
        TextView Gewicht = findViewById(R.id.GewichtI);

        db= new Datenbank(BenutzerInfo.this);
        List<PersonDaten> PersonenI= db.AllePersonen();
        List<PersonDaten> AktuelleD = db.getPersonDatenfurC();

        Double Groß = AktuelleD.get(0).getGroeße();
        Double Gewichtt = AktuelleD.get(0).getGewicht();
        Integer Alterr = AktuelleD.get(0).getAlter();

        Name.setText(AktuelleD.get(0).getName());
        Große.setText(Groß.toString());
        Alter.setText(Alterr.toString());
        Gewicht.setText(Gewichtt.toString());



        Graph.setDragEnabled(true);
        Graph.setScaleEnabled(true);




        ArrayList<Entry> yWerte = new ArrayList<>();

        yWerte.add(new Entry(0, (float) PersonenI.get(0).getGewicht()));
        yWerte.add(new Entry(1, (float) PersonenI.get(1).getGewicht()));
        yWerte.add(new Entry(2, (float) PersonenI.get(2).getGewicht()));
        yWerte.add(new Entry(3, (float) PersonenI.get(3).getGewicht()));
        yWerte.add(new Entry(4, (float) PersonenI.get(4).getGewicht()));
        yWerte.add(new Entry(5, (float) PersonenI.get(5).getGewicht()));

        LineDataSet set1 = new LineDataSet(yWerte,"Set1");

        set1.setFillAlpha(110);

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);

        LineData data = new LineData(dataSets);

        Graph.setData(data);


    }
}