package com.hackeranushi.grocerywalla.ProfileActivity.WishList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hackeranushi.grocerywalla.R;

public class WishListAdapter extends RecyclerView.Adapter<WishListAdapter.ViewHolder> {

    String [] str;
    Context context;

    public WishListAdapter(String[] str, Context context) {
        this.str = str;
        this.context = context;
    }

    @NonNull
    @Override
    public WishListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.wishlist_activity,parent,false);
        return new WishListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WishListAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return str.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView productImage, deleteProduct;
        TextView productName, productPrice, productCutPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            productImage = itemView.findViewById(R.id.wishList_product_img);
            productName = itemView.findViewById(R.id.wishList_product_name);
            productPrice = itemView.findViewById(R.id.wishList_recycle_product_price);
            productCutPrice = itemView.findViewById(R.id.wishlist_cut_price);
            deleteProduct = itemView.findViewById(R.id.deleteProduct);
        }
    }
}