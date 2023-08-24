package com.example.dietapp;

import android.content.Context;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
public class Datein {

    Context context;



    public String[] Info(String Name, String Alter, String Große, String Gewicht) {


        FileInputStream Daten;
        StringBuilder V, a, b, c;


        String[] Datein = new String[4];
        try {
            Datein = null;
            Daten = openFileInput("große.txt");

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

            Datein[0] = V.toString();
            Datein[1] = a.toString();
            Datein[2] = b.toString();
            Datein[3] = c.toString();






            return Datein;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.getMessage();
            e.printStackTrace();
        }


        return Datein;
    }

    private FileInputStream openFileInput(String große) throws FileNotFoundException {
        return context.openFileInput(große);
    }


    String Datenlesen() throws FileNotFoundException {
        FileInputStream Daten1 = null;
        Daten1 =  openFileInput("Name.txt");
        Scanner Scan = new Scanner(Daten1);
        String Datenb = null;
        while (Scan.hasNextLine()){
            Datenb = Scan.nextLine();
            //Toast.makeText(this, Datenb, Toast.LENGTH_SHORT).show();

        }
        return Datenb;
    }







}
