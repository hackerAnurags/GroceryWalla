package com.hackeranushi.grocerywalla.ProductDetails.ViewPgaerAdapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.hackeranushi.grocerywalla.R;

public class ProductDetailsViewAdapter extends PagerAdapter {
    private int[] arrayImage = new int[]
            {
                    R.drawable.first_photo,
                    R.drawable.first_slider,
                    R.drawable.second_slider,
                    R.drawable.third_slider,
                    R.drawable.fourth_slider
            };
    Context context;

    public ProductDetailsViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayImage.length;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        ImageView imageView = new ImageView(context);
        imageView.setBackgroundResource(arrayImage[position]);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        View view = (View) object;
        container.removeView(view);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

}
