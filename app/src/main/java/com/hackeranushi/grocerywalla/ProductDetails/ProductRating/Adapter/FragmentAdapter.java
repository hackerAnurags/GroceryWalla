package com.hackeranushi.grocerywalla.ProductDetails.ProductRating.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.hackeranushi.grocerywalla.ProductDetails.InfoFragment.HighLight;
import com.hackeranushi.grocerywalla.ProductDetails.InfoFragment.Info;
import com.hackeranushi.grocerywalla.ProductDetails.ProductRating.Fragments.Questions;
import com.hackeranushi.grocerywalla.ProductDetails.ProductRating.Fragments.Rating;

public class FragmentAdapter extends FragmentStateAdapter {
    private String[] titles = new String[]{"Rating","Questions"};
    public FragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                Rating rating = new Rating();
                return rating;
            case 1:
                Questions questions = new Questions();
                return questions;
            default:
                Rating rating1 = new Rating();
                return rating1;
        }
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}
