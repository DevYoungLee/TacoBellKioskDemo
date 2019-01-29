package com.youngmlee.tacobellkiosk.viewModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import android.app.Application;
import android.util.Log;

import com.youngmlee.tacobellkiosk.R;
import com.youngmlee.tacobellkiosk.data.Callback;
import com.youngmlee.tacobellkiosk.data.Repository;
import com.youngmlee.tacobellkiosk.data.RepositoryImpl;
import com.youngmlee.tacobellkiosk.data.model.Menu;
import com.youngmlee.tacobellkiosk.data.model.MenuItem;
import com.youngmlee.tacobellkiosk.data.model.Order;

import java.util.ArrayList;

public class OrderActivityViewModel extends AndroidViewModel {

    private static final String TAG = "retrieving_data";

    private Menu tacoBellMenu;
    private MutableLiveData<String> currentMenuCategory = null;
    private String[] categoryList;
    private MutableLiveData<ArrayList<MenuItem>> currentMenuList = null;
    private MutableLiveData<Double> currentOrderCost = null;
    private Order currentOrder;
    private Repository repository;

    public OrderActivityViewModel(@NonNull Application application) {
        super(application);
        repository = RepositoryImpl.getInstance();
        categoryList = application.getResources().getStringArray(R.array.menu_category_list);
    }

    public MutableLiveData<ArrayList<MenuItem>> getInitialItemList(){
        if (currentMenuList == null) {
            currentMenuList = new MutableLiveData<>();
            repository.getMenu(new Callback<Menu>() {
                @Override
                public void onSuccess(Menu menu) {
                    tacoBellMenu = menu;
                    currentMenuCategory.postValue(categoryList[0]);
                    currentMenuList.postValue(menu.getNewItems());
                }

                @Override
                public void onError(String message) {
                    Log.d(TAG, "Retrieving data failed: " + message);
                }
            });
        }
        return currentMenuList;
    }

    public MutableLiveData<Double> getCurrentOrderCost(){
        if(currentOrderCost == null) {
            currentOrderCost = new MutableLiveData<>();
            currentOrderCost.postValue(currentOrder.getCostOfOrder());
        }
        return currentOrderCost;
    }

    public void startNewOrder(){
        currentOrder = new Order();
    }

    public void addItemToOrder(MenuItem menuItem){
        currentOrder.addItemToOrder(menuItem);
        currentOrderCost.postValue(currentOrder.getCostOfOrder());
    }

    public void removeItemFromOrder(MenuItem menuItem){
        currentOrder.removeItemFromOrder(menuItem);
        currentOrderCost.postValue(currentOrder.getCostOfOrder());
    }

    public MutableLiveData<String> getCurrentMenuCategory(){
        if(currentMenuCategory == null) {
            currentMenuCategory = new MutableLiveData<>();
            currentMenuCategory.postValue(categoryList[0]);
        }
        return currentMenuCategory;
    }

    public Order getCurrentOrder(){
        return currentOrder;
    }

    public void newPositionClicked(int position){
        String clickedCategory = categoryList[position];
        if(!clickedCategory.equals(currentMenuCategory) && tacoBellMenu != null){
            currentMenuCategory.postValue(clickedCategory);
            switch (position){
                case 0:
                    currentMenuList.postValue(tacoBellMenu.getNewItems());
                    break;
                case 1:
                    currentMenuList.postValue(tacoBellMenu.getCombos());
                    break;
                case 2:
                    currentMenuList.postValue(tacoBellMenu.getSpecialties());
                    break;
                case 3:
                    currentMenuList.postValue(tacoBellMenu.getTacos());
                    break;
                case 4:
                    currentMenuList.postValue(tacoBellMenu.getBurritos());
                    break;
                case 5:
                    currentMenuList.postValue(tacoBellMenu.getQuesadillas());
                    break;
                case 6:
                    currentMenuList.postValue(tacoBellMenu.getNachos());
                    break;
                case 7:
                    currentMenuList.postValue(tacoBellMenu.getValueMenu());
                    break;
                case 8:
                    currentMenuList.postValue(tacoBellMenu.getSweets());
                    break;
                case 9:
                    currentMenuList.postValue(tacoBellMenu.getSides());
                    break;
                case 10:
                    currentMenuList.postValue(tacoBellMenu.getDrinks());
                    break;
                case 11:
                    currentMenuList.postValue(tacoBellMenu.getPowerMenu());
                    break;
                case 12:
                    currentMenuList.postValue(tacoBellMenu.getBreakfast());
                    break;
                case 13:
                    currentMenuList.postValue(tacoBellMenu.getVegetarian());
                    break;
            }
        }
    }

}
