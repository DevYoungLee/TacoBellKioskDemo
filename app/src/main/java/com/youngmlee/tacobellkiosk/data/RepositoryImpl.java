package com.youngmlee.tacobellkiosk.data;

import com.youngmlee.tacobellkiosk.data.model.Menu;

public class RepositoryImpl implements Repository {

    private static RepositoryImpl repositoryInstance = null;
    public Database database;

    private RepositoryImpl(){
        this.database = new FirebaseRealtimeDatabase();
    }

    public static RepositoryImpl getInstance(){
        if(repositoryInstance == null){
            repositoryInstance = new RepositoryImpl();
        }
        return repositoryInstance;
    }
    @Override
    public void getMenu(final Callback<Menu> callback) {
        database.getMenu(new Callback<Menu>() {
            @Override
            public void onSuccess(Menu menu) {
                callback.onSuccess(menu);
            }

            @Override
            public void onError(String message) {
                callback.onError(message);
            }
        });
    }
}
