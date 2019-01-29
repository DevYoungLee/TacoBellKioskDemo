package com.youngmlee.tacobellkiosk.ui.listAdapters;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.youngmlee.tacobellkiosk.R;
import com.youngmlee.tacobellkiosk.viewModel.OrderActivityViewModel;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.ViewHolder> {

    private String[] categoryList;
    private TypedArray categoryListItemIcon;
    private Context context;
    private OrderActivityViewModel orderActivityViewModel;

    public CategoryListAdapter(Context context, OrderActivityViewModel orderActivityViewModel){
        categoryList = context.getResources().getStringArray(R.array.menu_category_list);
        categoryListItemIcon = context.getResources().obtainTypedArray(R.array.menu_category_list_icon);
        this.context = context;
        this.orderActivityViewModel = orderActivityViewModel;
    }

    @NonNull
    @Override
    public CategoryListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.menu_category_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryListAdapter.ViewHolder holder, final int position) {
        holder.categoryNameTextView.setText(categoryList[position]);
        holder.categoryNameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderActivityViewModel.newPositionClicked(position);
            }
        });
        holder.categoryIconImageView.setImageResource(categoryListItemIcon.getResourceId(position, 0));
    }

    @Override
    public int getItemCount() {
        return categoryList.length;
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView categoryNameTextView;
        private ImageView categoryIconImageView;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryNameTextView = itemView.findViewById(R.id.tv_category_name);
            categoryIconImageView = itemView.findViewById(R.id.iv_category_icon);

        }
    }
}
