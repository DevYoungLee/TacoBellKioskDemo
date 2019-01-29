package com.youngmlee.tacobellkiosk.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.youngmlee.tacobellkiosk.R;
import com.youngmlee.tacobellkiosk.data.model.MenuItem;
import com.youngmlee.tacobellkiosk.utils.PriceFormatter;
import com.youngmlee.tacobellkiosk.viewModel.OrderActivityViewModel;

public class OrderConfirmationDialogFragment extends DialogFragment {

    private static final String ARG_MENU_ITEM = "arg_menu_item";
    public static final String CONFIRMATION_FRAGMENT_TAG = "confirmation_fragment";
    private MenuItem menuItem;
    private ImageView itemImageView;
    private TextView itemNameTextView;
    private TextView itemPriceTextView;
    private Button addConfirmationButton;

    private OrderActivityViewModel orderActivityViewModel;

    public OrderConfirmationDialogFragment() {
        // Required empty public constructor
    }


    public static OrderConfirmationDialogFragment newInstance(MenuItem menuItem) {
        OrderConfirmationDialogFragment fragment = new OrderConfirmationDialogFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_MENU_ITEM, menuItem);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        orderActivityViewModel = ViewModelProviders.of(getActivity()).get(OrderActivityViewModel.class);
        if (getArguments() != null) {
            menuItem = (MenuItem) getArguments().getSerializable(ARG_MENU_ITEM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_order_confirmation_dialog, container, false);
        itemImageView = view.findViewById(R.id.iv_confirmation_item_image);
        itemNameTextView = view.findViewById(R.id.tv_confirmation_item_name);
        itemPriceTextView = view.findViewById(R.id.tv_confirmation_item_price);
        addConfirmationButton = view.findViewById(R.id.b_add_confirmation);

        Picasso.get().load(menuItem.getImage()).into(itemImageView);;
        itemNameTextView.setText(menuItem.getName());
        String priceText = PriceFormatter.getInstance().formatPrice(menuItem.getPrice());
        itemPriceTextView.setText(priceText);


        addConfirmationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderActivityViewModel.addItemToOrder(menuItem);
                destroyFragment();
            }
        });

        return view;
    }

    private void destroyFragment(){
        getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
