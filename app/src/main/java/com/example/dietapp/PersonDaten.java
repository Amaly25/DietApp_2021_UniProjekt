package com.example.dietapp;

public class PersonDaten {
    String Name;
    double Groeße;
    int Alter;
    double Gewicht;
    int id;

    public PersonDaten(String name, double groeße, int alter, double gewicht, int Id) {
        Name = name;
        Groeße = groeße;
        Alter = alter;
        Gewicht = gewicht;
        id = Id;
    }
    public PersonDaten(){

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getGroeße() {
        return Groeße;
    }

    public void setGroeße(double groeße) {
        Groeße = groeße;
    }

    public int getAlter() {
        return Alter;
    }

    public void setAlter(int alter) {
        Alter = alter;
    }

    public double getGewicht() {
        return Gewicht;
    }

    public void setGewicht(double gewicht) {
        Gewicht = gewicht;
    }

    public String toString() {
        return
                "Name=" + Name +
                        ", Große =" + Groeße +
                        ", Alter =" + Alter +
                        ", Gewicht =" + Gewicht;
    }
}
