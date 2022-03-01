package com.hackeranushi.grocerywalla.ProductDetails.ProductRecycleAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hackeranushi.grocerywalla.R;

public class MoreProductAdapter extends RecyclerView.Adapter<MoreProductAdapter.ViewHolder> {
    String [] str;
    Context context;

    public MoreProductAdapter(String[] str, Context context) {
        this.str = str;
        this.context = context;
    }

    @NonNull
    @Override
    public MoreProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_product,parent,false);
        return new MoreProductAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoreProductAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return str.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView productName,productPrice,productRating;
        ImageView productImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            productName = itemView.findViewById(R.id.product_name);
            productImage = itemView.findViewById(R.id.product_image);
            productPrice = itemView.findViewById(R.id.product_price);
        }
    }
}
