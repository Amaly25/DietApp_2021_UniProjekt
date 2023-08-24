package com.example.dietapp;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FoodDataService {

    public static final String LINK = "http://fr.openfoodfacts.org/api/v0/product/";
    public static final String LINKa = "http://fr.openfoodfacts.org/api/v0/product/";


    Context context;
    String Places = "";
    String Name="";

    public FoodDataService(Context context) {
        this.context = context;
    }

    public interface VolleyResponseListener {
        void onError(String message);

        void onResponse(String responses);
    }

    public  void getName(String Barcode,String Bild,String Produktname,FoodData Liste){
        String url = LINK +Barcode;

// Request a string response from the provided URL.
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                List<FoodReportModel> Produkt = new ArrayList<>();
                Places = "";
                Name="";
                try {
                    JSONObject Info = response.getJSONObject("product");
                    //JSONObject B = Info.getJSONObject("nutriments");
                    FoodReportModel Infos = new FoodReportModel();
                    Infos.setName(Info.getString(Produktname));
                    Infos.setBild(Info.getString(Bild));

                Produkt.add(Infos);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                //Toast.makeText(context,"Places zum kaufen:"+Places, Toast.LENGTH_SHORT).show();
                Liste.onResponse(Produkt);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Toast.makeText(context, "Fehler", Toast.LENGTH_SHORT).show();
                Liste.onError("Kaputt");

            }
        });
// Add the request to the RequestQueue.
        com.example.dietapp.MySingleton.getInstance(context).addToRequestQueue(request);

    }

    public interface FoodData {
        void onError(String message);

        void onResponse(List<FoodReportModel> foodReportModel);
    }

    public void FoodInfo(String Food, FoodData foodData){
        String url = LINKa + Food;
        List<FoodReportModel> Info = new ArrayList<>();


        JsonObjectRequest b =new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject c = response.getJSONObject("product");
                    JSONObject d = c.getJSONObject("nutriments");

                    FoodReportModel Produktdata= new FoodReportModel();

                    Produktdata.setFat( d.getDouble("fat"));
                    Produktdata.setKalorien((d.getDouble("energy-kcal")));
                    Produktdata.setProtein((d.getDouble("proteins")));
                    Produktdata.setZucker(d.getDouble("sugars"));
                    Produktdata.setName(c.getString("product_name"));
                    Produktdata.setBild(c.getString("image_url"));

                    Info.add(Produktdata);

                    foodData.onResponse(Info);

                } catch (JSONException e) {
                    e.printStackTrace();
                }




            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        com.example.dietapp.MySingleton.getInstance(context).addToRequestQueue(b);
    }





}
