package com.youngmlee.tacobellkiosk.data;

public interface Callback<T> {
    void onSuccess(T t);
    void onError(String message);
}
