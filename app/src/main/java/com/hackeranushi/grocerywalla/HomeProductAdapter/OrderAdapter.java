package com.hackeranushi.grocerywalla.HomeProductAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hackeranushi.grocerywalla.R;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {

    String [] str;
    Context context;

    public OrderAdapter(String[] str, Context context) {
        this.str = str;
        this.context = context;
    }

    @NonNull
    @Override
    public OrderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_activity,parent,false);
        return new OrderAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return str.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView orderProductName, orderProductPrice, orderProductCutPrice, orderProductStatus;
        ImageView orderProductImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            orderProductName = itemView.findViewById(R.id.order_product_name);
            orderProductPrice = itemView.findViewById(R.id.order_product_price);
            orderProductCutPrice = itemView.findViewById(R.id.order_product_cut_price);
            orderProductStatus = itemView.findViewById(R.id.order_product_status);
            orderProductImage = itemView.findViewById(R.id.order_product_image);

        }
    }
}
