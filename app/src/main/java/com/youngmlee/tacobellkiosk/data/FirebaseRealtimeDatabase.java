package com.youngmlee.tacobellkiosk.data;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.youngmlee.tacobellkiosk.data.model.Menu;
import com.youngmlee.tacobellkiosk.data.model.MenuItem;

public class FirebaseRealtimeDatabase implements Database {

    private final String TAG = "Database";

    private final String MENU_KEY = "menu";
    private final String BREAKFAST_KEY = "breakfast";
    private final String BURRITOS_KEY = "burritos";
    private final String COMBOS_KEY = "combos";
    private final String DRINKS_KEY = "drinks";
    private final String NACHOS_KEY = "nachos";
    private final String NEW_ITEMS_KEY = "new_items";
    private final String POWER_MENU_KEY = "power_menu";
    private final String QUESEDILLAS_KEY = "quesadillas";
    private final String SIDES_KEY = "sides";
    private final String SPECIALTIES_KEY = "specialties";
    private final String SWEETS_KEY = "sweets";
    private final String TACOS_KEY = "tacos";
    private final String VALUE_MENU_KEY = "value_menu";
    private final String VEGETARIAN_KEY = "vegetarian";

    private DatabaseReference databaseReference;

    public FirebaseRealtimeDatabase(){
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        databaseReference = FirebaseDatabase.getInstance().getReference();
    }

    @Override
    public void getMenu(final Callback<Menu> menuCallback){
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                DataSnapshot menuDataSnapshot = dataSnapshot.child(MENU_KEY);

                Menu menu = new Menu();
                for(DataSnapshot item : menuDataSnapshot.child(BREAKFAST_KEY).getChildren()){
                    menu.getBreakfast().add(item.getValue(MenuItem.class));
                }
                for(DataSnapshot item : menuDataSnapshot.child(BURRITOS_KEY).getChildren()){
                    menu.getBurritos().add(item.getValue(MenuItem.class));
                }
                for(DataSnapshot item : menuDataSnapshot.child(COMBOS_KEY).getChildren()){
                    menu.getCombos().add(item.getValue(MenuItem.class));
                }
                for(DataSnapshot item : menuDataSnapshot.child(DRINKS_KEY).getChildren()){
                    menu.getDrinks().add(item.getValue(MenuItem.class));
                }
                for(DataSnapshot item : menuDataSnapshot.child(NACHOS_KEY).getChildren()){
                    menu.getNachos().add(item.getValue(MenuItem.class));
                }
                for(DataSnapshot item : menuDataSnapshot.child(NEW_ITEMS_KEY).getChildren()){
                    menu.getNewItems().add(item.getValue(MenuItem.class));
                }
                for(DataSnapshot item : menuDataSnapshot.child(POWER_MENU_KEY).getChildren()){
                    menu.getPowerMenu().add(item.getValue(MenuItem.class));
                }
                for(DataSnapshot item : menuDataSnapshot.child(QUESEDILLAS_KEY).getChildren()){
                    menu.getQuesadillas().add(item.getValue(MenuItem.class));
                }
                for(DataSnapshot item : menuDataSnapshot.child(SIDES_KEY).getChildren()){
                    menu.getSides().add(item.getValue(MenuItem.class));
                }
                for(DataSnapshot item : menuDataSnapshot.child(SPECIALTIES_KEY).getChildren()){
                    menu.getSpecialties().add(item.getValue(MenuItem.class));
                }
                for(DataSnapshot item : menuDataSnapshot.child(SWEETS_KEY).getChildren()){
                    menu.getSweets().add(item.getValue(MenuItem.class));
                }
                for(DataSnapshot item : menuDataSnapshot.child(TACOS_KEY).getChildren()){
                    menu.getTacos().add(item.getValue(MenuItem.class));
                }
                for(DataSnapshot item : menuDataSnapshot.child(VALUE_MENU_KEY).getChildren()){
                    menu.getValueMenu().add(item.getValue(MenuItem.class));
                }
                for(DataSnapshot item : menuDataSnapshot.child(VEGETARIAN_KEY).getChildren()){
                    menu.getVegetarian().add(item.getValue(MenuItem.class));
                }

                Log.d(TAG, "onDataChange itemName: " + menu.getCombos().get(0).getName());
                Log.d(TAG, "onDataChange itemPrice: " + menu.getCombos().get(0).getPrice());
                Log.d(TAG, "onDataChange itemCal: " + menu.getCombos().get(0).getCal());
                Log.d(TAG, "onDataChange itemImage : " + menu.getCombos().get(0).getImage());

                menuCallback.onSuccess(menu);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                menuCallback.onError(databaseError.getMessage());
            }
        });
    }
}
