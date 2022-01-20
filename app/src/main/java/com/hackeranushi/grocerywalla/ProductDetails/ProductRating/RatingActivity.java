package com.hackeranushi.grocerywalla.ProductDetails.ProductRating;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.hackeranushi.grocerywalla.ProductDetails.ProductRating.Adapter.FragmentAdapter;
import com.hackeranushi.grocerywalla.R;

public class RatingActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager;
    private String[] titles = new String[]{"Rating","Questions"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Rating & Review");
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.tabLayout_viewPager);

        FragmentAdapter fragmentAdapter = new FragmentAdapter(this);
        viewPager.setAdapter(fragmentAdapter);
        new TabLayoutMediator(tabLayout,viewPager,(tab, position) ->tab.setText(titles[position])).attach();

    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}