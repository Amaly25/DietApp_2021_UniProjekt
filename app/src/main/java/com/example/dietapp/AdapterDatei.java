package com.example.dietapp;
import android.content.Context;
import android.graphics.Path;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class AdapterDatei extends BaseAdapter {

    Context context;
    List<FoodReportModel> Food;

    public AdapterDatei(Context context, List<FoodReportModel> food) {
        this.context = context;
        Food = food;
    }

    @Override
    public int getCount() {
        return Food.size();
    }

    @Override
    public Object getItem(int position) {
        return Food.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_list_style,parent,false);
        }
        TextView Produktname,Zucker,Kal,Protein,Fat;
        ImageView Bild;
        Bild = convertView.findViewById(R.id.Images);
        Produktname = convertView.findViewById(R.id.ProduktN);
        Fat = convertView.findViewById(R.id.Fett);
        Zucker = convertView.findViewById(R.id.Zucker);
        Kal = convertView.findViewById(R.id.Kalorien);
        Protein= convertView.findViewById(R.id.Protein);


        Double F = Food.get(position).getFat();
        Double Z = Food.get(position).getZucker();
        Double K = Food.get(position).getKalorien();
        Double P = Food.get(position).getProtein();

        Fat.setText("Fett: "+F.toString());
        Zucker.setText("Zucker: "+Z.toString());
        Kal.setText("Kalorien: "+K.toString());
        Protein.setText("Proteine: "+P.toString());
        Produktname.setText("Name: "+Food.get(position).getName());
        Glide.with(convertView).load(Food.get(position).getBild()).into(Bild);




        return convertView;
    }
}
