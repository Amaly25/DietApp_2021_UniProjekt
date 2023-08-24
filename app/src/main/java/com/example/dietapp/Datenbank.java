package com.example.dietapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Datenbank extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 3;
    private static final String DATABASE_NAME = "FoodDB";
    private static final String TABLENAME = "Foodi";
    private static final String  Fat = "fat";
    private static final String Energykcal = "energykcal";
    private static final String Proteins = "proteins";
    private static final String Sugars = "sugars";
    private static final String  KEY_ID = "id";
    private static final String NAME = "Name";
    private static final String GROßE = "Große";
    private static final String ALTER = "P_ALTER";
    private static final String GEWICHT = "Gewicht";
    private static final String ID = "ID";
    private static final String PersonD = "PersonD";
    private static final String Names = "Name";
    private static final String Bild = "Bild";
    private static final String TABLENAME2 = "food";





        public Datenbank(@Nullable Context context) {
        super(context, DATABASE_NAME , null, DATABASE_VERSION);

    }
 @Override
        public void onCreate(SQLiteDatabase db) {
            String FDB = "CREATE TABLE " + TABLENAME + "("
                    + KEY_ID + " INTEGER  PRIMARY KEY ,"
                    + Fat + " DOUBLE,"
                    + Energykcal + " DOUBLE,"
                    + Proteins + " DOUBLE,"
                    + Sugars + " DOUBLE"



                    + ")";


     String FDB2 = "CREATE TABLE " + TABLENAME2 + "("
             + KEY_ID + " INTEGER  PRIMARY KEY ,"
             + Fat + " DOUBLE,"
             + Energykcal + " DOUBLE,"
             + Proteins + " DOUBLE,"
             + Sugars + " DOUBLE,"
             +Names + " TEXT,"
             +Bild + " Text"


             + ")";

     String PDB = "CREATE TABLE " + PersonD +"("
             + ID + " INTEGER  PRIMARY KEY ,"
             + NAME + " TEXT,"
             + GROßE + " DOUBLE,"
             + ALTER + " DOUBLE,"
             + GEWICHT + " DOUBLE"

             + ")";

    db.execSQL(FDB2);


        }

  @Override
           public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {



         onCreate(db);


        }

         void addFood(FoodReportModel F1) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Fat, F1.getFat());
        values.put(Energykcal, F1.getKalorien());
        values.put(Proteins, F1.getProtein());
        values.put(Sugars, F1.getZucker());
        values.put(Names, F1.getName());
        values.put(Bild, F1.getBild());


        // Inserting Row
        db.insert(TABLENAME2, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }


    void addEinzelDaten(String Name, String Große,String Alter,String Gewicht){
                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues Wert = new ContentValues();

                double Große1 = Double.parseDouble(Große);
                double Alter1 = Double.parseDouble(Alter);
                double Gewicht1 = Double.parseDouble(Gewicht);


                Wert.put(NAME,Name);
                Wert.put(GROßE,Große1);
                Wert.put(ALTER,Alter1);
                Wert.put(GEWICHT,Gewicht1);
        Log.d("hry:", Wert.toString());


            db.insert(PersonD,null,Wert);


    }
/* Spaeter wird das benutzt um von der Person Daten zu entnehmen und damit die Kalorien zuberechnen dazu brauchst du die letzte id des benutzers*/
    List<PersonDaten> getPersonDatenfurC(){

        List<PersonDaten> PersonList = new ArrayList<>();
        String selectQuery1 = "SELECT * FROM " + PersonD;
        SQLiteDatabase db1 = this.getWritableDatabase();
        Cursor cursor1 = db1.rawQuery(selectQuery1,null);
        int idxanzahl = cursor1.getCount();


        String selectQuery = "SELECT * FROM " + PersonD + " WHERE id ="+ idxanzahl;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);

        if (cursor.moveToFirst()){
            do {
                PersonDaten P1 = new PersonDaten();
                P1.setName(cursor.getString(1));
                P1.setGroeße(cursor.getDouble(2));
                P1.setAlter(cursor.getInt(3));
                P1.setGewicht(cursor.getDouble(4));

                PersonList.add(P1);


            }while (cursor.moveToNext());
        }

        return PersonList;
    }



    void EFood(String Fat1,String EKcal,String Proteins1,String Sugar1){
            SQLiteDatabase db = this.getWritableDatabase();

            ContentValues value = new ContentValues();
            double f = Double.parseDouble(Fat1);
            double E = Double.parseDouble(EKcal);
            double P = Double.parseDouble(Proteins1);
            double S = Double.parseDouble(Sugar1);


            value.put(Fat,f);
            value.put(Energykcal,EKcal);
            value.put(Proteins,Proteins1);
            value.put(Sugars,Sugar1);

            db.insert(TABLENAME,null,value);

    }

    public List<FoodReportModel> getAllFood() {
        List<FoodReportModel> Information = new ArrayList<FoodReportModel>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLENAME2;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                FoodReportModel P2 = new FoodReportModel();
                P2.setId(Integer.parseInt(cursor.getString(0)));
                P2.setFat(cursor.getDouble(1));
                P2.setKalorien(cursor.getDouble(2));
                P2.setProtein(cursor.getDouble(3));
                P2.setZucker(cursor.getDouble(4));
                P2.setName(cursor.getString(5));
                P2.setBild(cursor.getString(6));
                // Adding contact to list
                Information.add(P2);
            } while (cursor.moveToNext());
        }

        // return contact list
        return Information;
    }

    public List<PersonDaten> AllePersonen(){
        List<PersonDaten> PersonList = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + PersonD;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);

        if (cursor.moveToFirst()){
            do {
                PersonDaten P1 = new PersonDaten();
                P1.setName(cursor.getString(1));
                P1.setGroeße(cursor.getDouble(2));
                P1.setAlter(cursor.getInt(3));
                P1.setGewicht(cursor.getDouble(4));

                PersonList.add(P1);


            }while (cursor.moveToNext());
        }

        return PersonList;
    }


}

