package com.hackeranushi.grocerywalla.HomeProductAdapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.hackeranushi.grocerywalla.R;

public class ViewCustomAdapter extends PagerAdapter {

    private int[] arrayImage = new int[]
            {
                    R.drawable.banner,
                    R.drawable.banner2,
                    R.drawable.banner3,
                    R.drawable.banner4,
                    R.drawable.banner1
            };
    Context context;

    public ViewCustomAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayImage.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
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
}
