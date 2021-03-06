package com.hackeranushi.grocerywalla.HomeProductAdapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hackeranushi.grocerywalla.Models.HomeModel.CategoryModel;
import com.hackeranushi.grocerywalla.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder>{

    private List<CategoryModel> list;
    private Context context;

    public CategoryAdapter(List<CategoryModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @SuppressLint("NotifyDataSetChanged")
    public  void filterList(ArrayList<CategoryModel> filterllist) {
        // below line is to add our filtered
        // list in our course array list.
        list = filterllist;
        notifyDataSetChanged();
        // below line is to notify our adapter
        // as change in recycler view data.
    }

    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_product_category,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder holder, int position) {
        holder.catName.setText(list.get(position).getCatName());
        Glide.with(context).load(list.get(position).getCatImage()).into(holder.catImage);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView catImage;
        TextView catName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            catImage = itemView.findViewById(R.id.category_product_image);
            catName = itemView.findViewById(R.id.category_product_name);
        }
    }
}
