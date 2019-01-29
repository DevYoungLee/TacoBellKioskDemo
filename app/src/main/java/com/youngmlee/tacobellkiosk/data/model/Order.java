package com.youngmlee.tacobellkiosk.data.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Order implements Serializable {
    private ArrayList<MenuItem> orderItems;

    public Order(){
        orderItems = new ArrayList<>();
    }

    public void addItemToOrder(MenuItem item){
        orderItems.add(item);
    }

    public double getCostOfOrder(){
        double cost = 0;
        if(!orderItems.isEmpty()){
            for(MenuItem item: orderItems){
                cost += item.getPrice();
            }
        }
        return cost;
    }

    public ArrayList<MenuItem> getOrderItems() {
        return orderItems;
    }

    public void removeItemFromOrder(MenuItem item){
        orderItems.remove(item);
    }


    public int getOrderItemCount(){
        return orderItems.size();
    }
}
