package com.hackeranushi.grocerywalla.HomeProductAdapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.hackeranushi.grocerywalla.R;

public class HomeViewAdapter extends PagerAdapter {
    private int[] array_image=new int[]{
            R.drawable.first_slider,
            R.drawable.second_slider,
            R.drawable.third_slider,
            R.drawable.fourth_slider};

    Context ctx;

    public HomeViewAdapter(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return array_image.length;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView=new ImageView(ctx);
        imageView.setBackgroundResource(array_image[position]);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        View view=(View) object;
        container.removeView(view);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }
}
