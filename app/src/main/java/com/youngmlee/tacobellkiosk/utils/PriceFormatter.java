package com.youngmlee.tacobellkiosk.utils;

public class PriceFormatter {
    private static PriceFormatter priceFormatterInstance = null;

    private PriceFormatter(){
    }

    public static PriceFormatter getInstance(){
        if(priceFormatterInstance == null){
            priceFormatterInstance = new PriceFormatter();
        }
        return priceFormatterInstance;
    }

    public String formatPrice(double price){
        String priceText = new StringBuilder().append("$").append(String.format("%.2f", price)).toString();
        return priceText;
    }
}
