package com.hackeranushi.grocerywalla.HomeProductAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hackeranushi.grocerywalla.HomeProductModel.CartModel;
import com.hackeranushi.grocerywalla.R;
import com.skydoves.elasticviews.ElasticImageView;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
//    ArrayList<CartModel> cartModels;
    int i;
    String[] str;
    Context context;

    public CartAdapter(int i,String[] str, Context context) {
//        this.cartModels = cartModels;
        this.i = i;
        this.str = str;
        this.context = context;
    }

    @NonNull
    @Override
    public CartAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = null;
        if (i == 0)
        {
            view = LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.cart_activity,parent,false);
        }else if (i==1)
        {
            view = LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.home_product,parent,false);
        }


        return new CartAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.ViewHolder holder, int position) {
        if (i==0)
        {

        }else if (i==1)
        {

        }

    }

    @Override
    public int getItemCount() {
        return str.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView cartProductImage, productImage;
        ElasticImageView cartRemoveProduct,cartAddProduct,RemoveItem;
        TextView cartProductName, cartProductPrice, cartProductCutPrice, cartProductQuantity,
                productName,productPrice,productRating;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            if (i==0)
            {
                cartProductImage = itemView.findViewById(R.id.mycart_product_img);
                cartRemoveProduct = itemView.findViewById(R.id.mycart_remove_product);
                cartAddProduct = itemView.findViewById(R.id.mycart_add_product);
                RemoveItem = itemView.findViewById(R.id.remove_items);
                cartProductName = itemView.findViewById(R.id.mycart_product_name);
                cartProductPrice = itemView.findViewById(R.id.mycart_recycle_product_price);
                cartProductCutPrice = itemView.findViewById(R.id.mycart_cut_price);
                cartProductQuantity = itemView.findViewById(R.id.mycart_number_quantity);

            } else if (i==1)
            {
                productName = itemView.findViewById(R.id.product_name);
                productImage = itemView.findViewById(R.id.product_image);
                productPrice = itemView.findViewById(R.id.product_price);
            }

        }
    }
}
