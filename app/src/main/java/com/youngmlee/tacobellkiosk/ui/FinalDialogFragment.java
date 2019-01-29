package com.youngmlee.tacobellkiosk.ui;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.youngmlee.tacobellkiosk.R;

public class FinalDialogFragment extends DialogFragment {

    public static final String FINAL_FRAGMENT_TAG = "final_fragment";

    private Button makeNewOrderButton;

    public FinalDialogFragment() {
        // Required empty public constructor
    }

    public static FinalDialogFragment newInstance() {
        FinalDialogFragment fragment = new FinalDialogFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_final_dialog, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                dispatchWelcomeActivity();
            }
        };
        handler.postDelayed(runnable, 3000);
    }

    private void dispatchWelcomeActivity(){
        Intent welcomeActivityIntent = new Intent(getContext(), WelcomeActivity.class);
        welcomeActivityIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(welcomeActivityIntent);
    }

}
