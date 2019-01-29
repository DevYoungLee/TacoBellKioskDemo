package com.youngmlee.tacobellkiosk.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.youngmlee.tacobellkiosk.R;
import com.youngmlee.tacobellkiosk.ui.listAdapters.CategoryListAdapter;
import com.youngmlee.tacobellkiosk.viewModel.OrderActivityViewModel;

public class MenuCategoryListFragment extends Fragment {

    private OrderActivityViewModel orderActivityViewModel;

    private RecyclerView categoryListRecyclerView;
    private LinearLayoutManager categoryListLayoutManager;
    private RecyclerView.Adapter categoryListAdapter;

    public MenuCategoryListFragment() {
        // Required empty public constructor
    }

    public static MenuCategoryListFragment newInstance() {
        MenuCategoryListFragment fragment = new MenuCategoryListFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        orderActivityViewModel = ViewModelProviders.of(getActivity()).get(OrderActivityViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_category, container, false);
        categoryListRecyclerView = view.findViewById(R.id.rv_categories);
        categoryListLayoutManager = new LinearLayoutManager(getContext());
        categoryListAdapter = new CategoryListAdapter(getContext(), orderActivityViewModel);

        categoryListRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), categoryListLayoutManager.getOrientation()));
        categoryListRecyclerView.setHasFixedSize(true);

        categoryListRecyclerView.setLayoutManager(categoryListLayoutManager);
        categoryListRecyclerView.setAdapter(categoryListAdapter);
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
