package com.hackeranushi.grocerywalla.ProductDetails.ViewPgaerAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.hackeranushi.grocerywalla.ProductDetails.InfoFragment.HighLight;
import com.hackeranushi.grocerywalla.ProductDetails.InfoFragment.Info;

public class TabularViewPagerAdapter extends FragmentStateAdapter {

    private String[] titles = new String[]{"HighLights","Information"};
    public TabularViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                HighLight highLight = new HighLight();
                return highLight;
            case 1:
                Info info = new Info();
                return info;
            default:
                HighLight highLight1 = new HighLight();
                return highLight1;
        }
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}
