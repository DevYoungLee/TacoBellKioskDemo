package com.youngmlee.tacobellkiosk.data.model;


import java.io.Serializable;

public class MenuItem implements Serializable {
    private String name;
    private String cal;
    private double price;
    private String image;

    public MenuItem(){

    }

    public MenuItem(String name, String cal, double price, String image){
        this.name = name;
        this.cal = cal;
        this.price = price;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCal() {
        return cal;
    }

    public void setCal(String cal) {
        this.cal = cal;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
