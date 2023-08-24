package com.example.dietapp;

public class FoodReportModel {
    int Id;
    double zucker;
    double kalorien;
    double fat;
    double protein;
    String Name;
    String Bild;





    public FoodReportModel(double zucker, double kalorien, double fat, double protein) {
        this.zucker = zucker;
        this.kalorien = kalorien;
        this.fat = fat;
        this.protein = protein;
    }

    public FoodReportModel(double zucker, double kalorien, double fat, double protein, String name, String bild) {
        this.zucker = zucker;
        this.kalorien = kalorien;
        this.fat = fat;
        this.protein = protein;
        Name = name;
        Bild = bild;
    }

    public FoodReportModel() {
    }

    public String getBild() {
        return Bild;
    }

    public void setBild(String bild) {
        Bild = bild;
    }

    @Override
    public String toString() {
        return
                "zucker=" + zucker +
                        ", kalorien=" + kalorien +
                        ", fat=" + fat +
                        ", protein=" + protein;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public double getZucker() {
        return zucker;
    }

    public void setZucker(double zucker) {
        this.zucker = zucker;
    }

    public double getKalorien() {
        return kalorien;
    }

    public void setKalorien(double kalorien) {
        this.kalorien = kalorien;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }
}
