package com.youngmlee.tacobellkiosk.data.model;

import java.util.ArrayList;

public class Menu {

    private ArrayList<MenuItem> breakfast;
    private ArrayList<MenuItem> burritos;
    private ArrayList<MenuItem> combos;
    private ArrayList<MenuItem> drinks;
    private ArrayList<MenuItem> nachos;
    private ArrayList<MenuItem> newItems;
    private ArrayList<MenuItem> powerMenu;
    private ArrayList<MenuItem> quesadillas;
    private ArrayList<MenuItem> sides;
    private ArrayList<MenuItem> specialties;
    private ArrayList<MenuItem> sweets;
    private ArrayList<MenuItem> tacos;
    private ArrayList<MenuItem> valueMenu;
    private ArrayList<MenuItem> vegetarian;

    public Menu(){
        breakfast = new ArrayList<>();
        burritos = new ArrayList<>();
        combos = new ArrayList<>();
        drinks = new ArrayList<>();
        nachos = new ArrayList<>();
        newItems = new ArrayList<>();
        powerMenu = new ArrayList<>();
        quesadillas = new ArrayList<>();
        sides = new ArrayList<>();
        specialties = new ArrayList<>();
        sweets = new ArrayList<>();
        tacos = new ArrayList<>();
        valueMenu = new ArrayList<>();
        vegetarian = new ArrayList<>();
    }

    public ArrayList<MenuItem> getBreakfast() {
        return breakfast;
    }

    public ArrayList<MenuItem> getBurritos() {
        return burritos;
    }

    public ArrayList<MenuItem> getCombos() {
        return combos;
    }

    public ArrayList<MenuItem> getDrinks() {
        return drinks;
    }

    public ArrayList<MenuItem> getNachos() {
        return nachos;
    }

    public ArrayList<MenuItem> getNewItems() {
        return newItems;
    }

    public ArrayList<MenuItem> getPowerMenu() {
        return powerMenu;
    }

    public ArrayList<MenuItem> getQuesadillas() {
        return quesadillas;
    }

    public ArrayList<MenuItem> getSides() {
        return sides;
    }

    public ArrayList<MenuItem> getSpecialties() {
        return specialties;
    }

    public ArrayList<MenuItem> getSweets() {
        return sweets;
    }

    public ArrayList<MenuItem> getTacos() {
        return tacos;
    }

    public ArrayList<MenuItem> getValueMenu() {
        return valueMenu;
    }

    public ArrayList<MenuItem> getVegetarian() {
        return vegetarian;
    }
}
