package com.youngmlee.tacobellkiosk.ui.listAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.youngmlee.tacobellkiosk.R;
import com.youngmlee.tacobellkiosk.data.model.MenuItem;
import com.youngmlee.tacobellkiosk.utils.PriceFormatter;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class OrderSummaryListAdapter extends RecyclerView.Adapter<OrderSummaryListAdapter.ViewHolder> {
    private Context context;
    private ArrayList<MenuItem> menuItems;

    public OrderSummaryListAdapter(Context context, ArrayList<MenuItem> menuItems){
        this.context = context;
        this.menuItems = menuItems;
    }

    @NonNull
    @Override
    public OrderSummaryListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.order_summary_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderSummaryListAdapter.ViewHolder holder, int position) {
        MenuItem menuItem = menuItems.get(position);
        Picasso.get().load(menuItem.getImage()).into(holder.itemImageView);
        holder.itemNameTextView.setText(menuItem.getName());
        String priceText = PriceFormatter.getInstance().formatPrice(menuItem.getPrice());
        holder.itemPriceTextView.setText(priceText);
    }

    @Override
    public int getItemCount() {
        return menuItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView itemImageView;
        private TextView itemNameTextView;
        private TextView itemPriceTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImageView = itemView.findViewById(R.id.iv_summary_image);
            itemNameTextView = itemView.findViewById(R.id.tv_summary_item_name);
            itemPriceTextView = itemView.findViewById(R.id.tv_summary_item_price);
        }
    }
}
