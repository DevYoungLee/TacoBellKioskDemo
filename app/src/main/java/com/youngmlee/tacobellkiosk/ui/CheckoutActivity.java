package com.youngmlee.tacobellkiosk.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.youngmlee.tacobellkiosk.R;
import com.youngmlee.tacobellkiosk.data.model.Order;
import com.youngmlee.tacobellkiosk.ui.listAdapters.OrderSummaryListAdapter;
import com.youngmlee.tacobellkiosk.utils.PriceFormatter;

public class CheckoutActivity extends AppCompatActivity {

    private final double california_tax_rate = 0.0725;

    private Order order;
    private NumberPicker mildSauceNumberPicker;
    private NumberPicker hotSauceNumberPicker;
    private NumberPicker fireSauceNumberPicker;
    private NumberPicker diabloSauceNumberPicker;
    private Button backToMenuButton;
    private TextView orderSubtotalCostTextView;
    private TextView orderTaxCostTextView;
    private TextView orderTotalCostTextView;
    private Button payWithCashButton;
    private Button payWithCardButton;
    private Button payWithGiftCardButton;

    private RecyclerView orderSummaryRecyclerView;
    private LinearLayoutManager linearLayoutManager;
    private OrderSummaryListAdapter orderSummaryListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        if(getIntent().getExtras() != null){
            order = (Order) getIntent().getSerializableExtra(OrderActivity.ORDER_EXTRA);
        }

        mildSauceNumberPicker = findViewById(R.id.np_mild_sauce);
        hotSauceNumberPicker = findViewById(R.id.np_hot_sauce);
        fireSauceNumberPicker = findViewById(R.id.np_fire_sauce);
        diabloSauceNumberPicker = findViewById(R.id.np_diablo_sauce);
        orderSummaryRecyclerView = findViewById(R.id.rv_order_summary_list);
        backToMenuButton = findViewById(R.id.b_back_to_menu);
        orderSubtotalCostTextView = findViewById(R.id.tv_order_subtotal_cost);
        orderTaxCostTextView = findViewById(R.id.tv_order_tax_cost);
        orderTotalCostTextView = findViewById(R.id.tv_order_total_cost);
        payWithCashButton = findViewById(R.id.b_pay_with_cash);
        payWithCardButton = findViewById(R.id.b_pay_with_card);
        payWithGiftCardButton = findViewById(R.id.b_pay_with_gift_card);

        backToMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        setUpNumberPicker(mildSauceNumberPicker);
        setUpNumberPicker(hotSauceNumberPicker);
        setUpNumberPicker(fireSauceNumberPicker);
        setUpNumberPicker(diabloSauceNumberPicker);

        orderSummaryRecyclerView = findViewById(R.id.rv_order_summary_list);
        linearLayoutManager = new LinearLayoutManager(this);
        orderSummaryRecyclerView.addItemDecoration(new DividerItemDecoration(this, linearLayoutManager.getOrientation()));
        orderSummaryListAdapter = new OrderSummaryListAdapter(this, order.getOrderItems());
        orderSummaryRecyclerView.setLayoutManager(linearLayoutManager);
        orderSummaryRecyclerView.setAdapter(orderSummaryListAdapter);

        double subTotal = order.getCostOfOrder();
        double tax = california_tax_rate * subTotal;
        double orderTotal = subTotal + tax;

        String subtotalText = "Subtotal: " + PriceFormatter.getInstance().formatPrice(subTotal);
        String taxText = "Tax: " + PriceFormatter.getInstance().formatPrice(tax);
        String orderTotalText = "Total: " + PriceFormatter.getInstance().formatPrice(orderTotal);
        orderSubtotalCostTextView.setText(subtotalText);
        orderTaxCostTextView.setText(taxText);
        orderTotalCostTextView.setText(orderTotalText);

        payWithCashButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFinalDialog();
            }
        });

        payWithCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFinalDialog();
            }
        });

        payWithGiftCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFinalDialog();
            }
        });
    }

    private void setUpNumberPicker(NumberPicker numberPicker) {
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(10);
        numberPicker.setWrapSelectorWheel(false);
    }

    private void showFinalDialog(){
        DialogFragment finalDialogFragment = FinalDialogFragment.newInstance();
        finalDialogFragment.setCancelable(false);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        Fragment previousFragment = getSupportFragmentManager().findFragmentByTag(FinalDialogFragment.FINAL_FRAGMENT_TAG);
        if(previousFragment != null) {
            fragmentTransaction.remove(previousFragment);
        }
        finalDialogFragment.show(fragmentTransaction, FinalDialogFragment.FINAL_FRAGMENT_TAG);
    }
}
