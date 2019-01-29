package com.youngmlee.tacobellkiosk.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.youngmlee.tacobellkiosk.R;
import com.youngmlee.tacobellkiosk.data.model.MenuItem;
import com.youngmlee.tacobellkiosk.ui.listAdapters.ItemListAdapter;
import com.youngmlee.tacobellkiosk.viewModel.OrderActivityViewModel;

import java.util.ArrayList;

public class MenuItemListFragment extends Fragment {

    private OrderActivityViewModel orderActivityViewModel;

    private RecyclerView itemListRecyclerView;
    private RecyclerView.LayoutManager itemListLayoutManager;
    private RecyclerView.Adapter itemListAdapter;

    public MenuItemListFragment() {
        // Required empty public constructor
    }

    public static MenuItemListFragment newInstance() {
        MenuItemListFragment fragment = new MenuItemListFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        orderActivityViewModel = ViewModelProviders.of(getActivity()).get(OrderActivityViewModel.class);
        orderActivityViewModel.getInitialItemList().observe(this, new Observer<ArrayList<MenuItem>>() {
            @Override
            public void onChanged(ArrayList<MenuItem> menuItemList) {
                itemListLayoutManager = new GridLayoutManager(getContext(), 4);
                itemListAdapter = new ItemListAdapter(getContext(), getActivity().getSupportFragmentManager(), menuItemList, orderActivityViewModel);

                itemListRecyclerView.setLayoutManager(itemListLayoutManager);
                itemListRecyclerView.setAdapter(itemListAdapter);
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_item_list, container, false);
        itemListRecyclerView = view.findViewById(R.id.rv_items);
        itemListRecyclerView.setHasFixedSize(true);
        return view;
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
