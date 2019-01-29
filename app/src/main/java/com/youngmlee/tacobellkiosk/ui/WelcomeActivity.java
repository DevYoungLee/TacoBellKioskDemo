package com.youngmlee.tacobellkiosk.ui;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityOptionsCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.youngmlee.tacobellkiosk.R;

public class WelcomeActivity extends AppCompatActivity {

    private ConstraintLayout constraintLayout;
    private ImageView logoImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        constraintLayout = findViewById(R.id.cl_welcome);
        logoImageView = findViewById(R.id.iv_live_mas_welcome);
        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dispatchOrderActivity();
            }
        });
    }

    private void dispatchOrderActivity(){
        Intent orderIntent = new Intent(getApplicationContext(), OrderActivity.class);
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat
                .makeSceneTransitionAnimation(this, logoImageView, getString(R.string.live_mas_logo_transition_name));
        startActivity(orderIntent, optionsCompat.toBundle());
    }
}
