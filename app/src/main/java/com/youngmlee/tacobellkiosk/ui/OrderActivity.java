package com.youngmlee.tacobellkiosk.ui;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.youngmlee.tacobellkiosk.R;
import com.youngmlee.tacobellkiosk.data.model.Order;
import com.youngmlee.tacobellkiosk.utils.PriceFormatter;
import com.youngmlee.tacobellkiosk.viewModel.OrderActivityViewModel;

public class OrderActivity extends AppCompatActivity {
    private final String TAG = "order_activity";
    public final static String ORDER_EXTRA = "order_extra";

    private ImageView liveMasImageView;
    private TextView menuCategoryTextView;
    private TextView costTextView;
    private Button cancelOrderButton;
    private Button checkOutButton;
    private OrderActivityViewModel orderActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        liveMasImageView = findViewById(R.id.iv_live_mas);
        menuCategoryTextView = findViewById(R.id.tv_menu_category);
        costTextView = findViewById(R.id.tv_order_cost);
        cancelOrderButton = findViewById(R.id.b_cancel_order);
        checkOutButton = findViewById(R.id.b_checkout);

        orderActivityViewModel = ViewModelProviders.of(this).get(OrderActivityViewModel.class);

        if(savedInstanceState == null){
            orderActivityViewModel.startNewOrder();
        }

        orderActivityViewModel.getCurrentMenuCategory().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                menuCategoryTextView.setText(s);
            }
        });

        orderActivityViewModel.getCurrentOrderCost().observe(this, new Observer<Double>() {
            @Override
            public void onChanged(Double aDouble) {
                String priceText = PriceFormatter.getInstance().formatPrice(aDouble);
                costTextView.setText(priceText);
            }
        });

        cancelOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        checkOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Order order = orderActivityViewModel.getCurrentOrder();
                if(order.getOrderItemCount() != 0){
                    Intent checkOutIntent = new Intent(getApplicationContext(), CheckoutActivity.class);
                    checkOutIntent.putExtra(ORDER_EXTRA, order);
                    startActivity(checkOutIntent);
                }
                else{
                    Toast.makeText(getApplicationContext(), getString(R.string.empty_order_message), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
