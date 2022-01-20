package com.hackeranushi.grocerywalla.MenuActivity.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hackeranushi.grocerywalla.MenuActivity.NewProductHomepage;
import com.hackeranushi.grocerywalla.R;

public class NewProductAdapter extends RecyclerView.Adapter<NewProductAdapter.ViewHolder> {
    String[] str;
    Context context;

    public NewProductAdapter(String[] str, Context context) {
        this.str = str;
        this.context = context;
    }

    @NonNull
    @Override
    public NewProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_product,parent,false);
        return new NewProductAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewProductAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return str.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView productImage;
        TextView productName, productPrice,productRating;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            productImage = itemView.findViewById(R.id.product_image);
            productName = itemView.findViewById(R.id.product_name);
            productPrice = itemView.findViewById(R.id.product_price);
            productRating = itemView.findViewById(R.id.product_rating);
        }
    }
}
