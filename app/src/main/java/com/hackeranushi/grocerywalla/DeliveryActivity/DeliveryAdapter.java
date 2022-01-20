package com.hackeranushi.grocerywalla.DeliveryActivity;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hackeranushi.grocerywalla.R;
import com.skydoves.elasticviews.ElasticImageView;

public class DeliveryAdapter extends RecyclerView.Adapter<DeliveryAdapter.ViewHolder> {

    String[] str;
    Context context;

    public DeliveryAdapter(String[] str, Context context) {
        this.str = str;
        this.context = context;
    }

    @NonNull
    @Override
    public DeliveryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate
                (R.layout.cart_activity,parent,false);
        return new DeliveryAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DeliveryAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView cartProductImage;
        ElasticImageView cartRemoveProduct,cartAddProduct,RemoveItem;
        TextView cartProductName, cartProductPrice, cartProductCutPrice, cartProductQuantity;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cartProductImage = itemView.findViewById(R.id.mycart_product_img);
            cartRemoveProduct = itemView.findViewById(R.id.mycart_remove_product);
            cartAddProduct = itemView.findViewById(R.id.mycart_add_product);
            RemoveItem = itemView.findViewById(R.id.remove_items);
            cartProductName = itemView.findViewById(R.id.mycart_product_name);
            cartProductPrice = itemView.findViewById(R.id.mycart_recycle_product_price);
            cartProductCutPrice = itemView.findViewById(R.id.mycart_cut_price);
            cartProductQuantity = itemView.findViewById(R.id.mycart_number_quantity);
        }
    }
}