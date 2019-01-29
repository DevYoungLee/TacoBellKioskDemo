package com.youngmlee.tacobellkiosk;

import android.app.Application;

import com.squareup.picasso.LruCache;

import com.squareup.picasso.Picasso;

public class CustomApplication extends Application {

    private int maxCacheSize = 500 * 1024 * 1024;

    @Override
    public void onCreate() {
        super.onCreate();
        Picasso picasso = new Picasso.Builder(this)
                .memoryCache(new LruCache(maxCacheSize))
                .build();

        Picasso.setSingletonInstance(picasso);
    }
}
