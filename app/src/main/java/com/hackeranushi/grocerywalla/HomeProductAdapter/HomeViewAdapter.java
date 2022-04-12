package com.hackeranushi.grocerywalla.HomeProductAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.hackeranushi.grocerywalla.Models.HomeModel.HomeSliderModel;
import com.hackeranushi.grocerywalla.R;

import java.util.ArrayList;

public class HomeViewAdapter extends PagerAdapter {
    ArrayList<HomeSliderModel> list;

    public HomeViewAdapter(ArrayList<HomeSliderModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view= LayoutInflater.from(container.getContext()).inflate(R.layout.home_slider,container,false);
        ImageView banner=view.findViewById(R.id.banner_slide_homepage);
        Glide.with(container.getContext()).load(list.get(position)).apply(new RequestOptions()
                .placeholder(R.drawable.first_slider)).into(banner);

        container.addView(view,0);
        return view;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
