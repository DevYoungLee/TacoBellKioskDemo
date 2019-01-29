package com.youngmlee.tacobellkiosk.ui.listAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.youngmlee.tacobellkiosk.R;
import com.youngmlee.tacobellkiosk.data.model.MenuItem;
import com.youngmlee.tacobellkiosk.ui.OrderConfirmationDialogFragment;
import com.youngmlee.tacobellkiosk.utils.PriceFormatter;
import com.youngmlee.tacobellkiosk.viewModel.OrderActivityViewModel;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ViewHolder> {
    
    private ArrayList<MenuItem> menuItems;
    private Context context;
    private FragmentManager fragmentManager;
    
    public ItemListAdapter(Context context, FragmentManager fragmentManager, ArrayList<MenuItem> menuItems, OrderActivityViewModel orderActivityViewModel){
        this.context = context;
        this.fragmentManager = fragmentManager;
        this.menuItems = menuItems;
    }
    
    @NonNull
    @Override
    public ItemListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.menu_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemListAdapter.ViewHolder holder, final int position) {
        final MenuItem menuItem = menuItems.get(position);
        Picasso.get().load(menuItem.getImage()).into(holder.itemImageView);
        holder.itemNameTextView.setText(menuItem.getName());
        String priceText = PriceFormatter.getInstance().formatPrice(menuItem.getPrice());
        holder.itemPriceTextView.setText(priceText);
        String calText = new StringBuilder().append("cal: ").append(menuItem.getCal()).toString();
        holder.itemCalTextView.setText(calText);
        holder.addToOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment confirmationDialogFragment = OrderConfirmationDialogFragment.newInstance(menuItem);
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment previousFragment = fragmentManager.findFragmentByTag(OrderConfirmationDialogFragment.CONFIRMATION_FRAGMENT_TAG);
                if(previousFragment != null) {
                    fragmentTransaction.remove(previousFragment);
                }
                confirmationDialogFragment.show(fragmentTransaction, OrderConfirmationDialogFragment.CONFIRMATION_FRAGMENT_TAG);
            }
        });
    }

    @Override
    public int getItemCount() {
        return menuItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView itemImageView;
        private TextView itemNameTextView;
        private TextView itemPriceTextView;
        private TextView itemCalTextView;
        private Button addToOrderButton;
        
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImageView = itemView.findViewById(R.id.iv_item_image);
            itemNameTextView = itemView.findViewById(R.id.tv_item_name);
            itemPriceTextView = itemView.findViewById(R.id.tv_item_price);
            itemCalTextView = itemView.findViewById(R.id.tv_item_cal);
            addToOrderButton = itemView.findViewById(R.id.b_item_add);
        }
    }
}
