package com.hackeranushi.grocerywalla.ProductDetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.hackeranushi.grocerywalla.DeliveryActivity.DeliveryActivity;
import com.hackeranushi.grocerywalla.MainActivity;
import com.hackeranushi.grocerywalla.ProductDetails.ProductRating.RatingActivity;
import com.hackeranushi.grocerywalla.ProductDetails.ProductRecycleAdapter.MoreProductAdapter;
import com.hackeranushi.grocerywalla.ProductDetails.ProductRecycleAdapter.PopularProductAdapter;
import com.hackeranushi.grocerywalla.ProductDetails.ViewPgaerAdapter.ProductDetailsViewAdapter;
import com.hackeranushi.grocerywalla.ProductDetails.ViewPgaerAdapter.TabularViewPagerAdapter;
import com.hackeranushi.grocerywalla.ProfileActivity.Coupons.Coupons;
import com.hackeranushi.grocerywalla.R;
import com.skydoves.elasticviews.ElasticButton;
import com.skydoves.elasticviews.ElasticImageView;

import me.relex.circleindicator.CircleIndicator;

public class ProductInfo extends AppCompatActivity {

    ViewPager productDetailsViewPager;
    ViewPager2 productInformationFragView;
    TabLayout tabLayout;
    CircleIndicator circleIndicator;
    RecyclerView moreRecycler, popularRecycler;
    TabularViewPagerAdapter tabularViewPagerAdapter;
    LinearLayout ratingActivity, couponLayout;
    private final String[] titles = new String[]{"HighLights","Information"};
    String[] str=new String[]{"","","","","","","","","","","","",""};
    ElasticImageView backButton;
    ElasticButton addCart,continuePayment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_info);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Product Details");
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        productDetailsViewPager = findViewById(R.id.product_detail_viewpager);
        circleIndicator = findViewById(R.id.product_detail_circle_indicator);
        productInformationFragView = findViewById(R.id.product_detail_viewpage_tab);
        tabLayout = findViewById(R.id.product_detail_desc_tab);
        ratingActivity = findViewById(R.id.product_detail_rating);

        moreRecycler = findViewById(R.id.product_detail_more_item_recycle);
        popularRecycler = findViewById(R.id.product_detail_popular_product_recycle);
        continuePayment = findViewById(R.id.product_detail_continue_payment);
        couponLayout = findViewById(R.id.coupon_layout);
        addCart = findViewById(R.id.product_detail_addToCart_button);


        ratingActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RatingActivity.class);
                startActivity(intent);
            }
        });

        continuePayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DeliveryActivity.class);
                startActivity(intent);
            }
        });

        couponLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Coupons.class);
                startActivity(intent);
            }
        });

        // Product item listing Viewpager

        ProductDetailsViewAdapter productDetailsViewAdapter = new ProductDetailsViewAdapter(getApplicationContext());
        productDetailsViewPager.setAdapter(productDetailsViewAdapter);
        circleIndicator.setViewPager(productDetailsViewPager);

        /////////////////////////////////////////////////

        /// Product Description TabLayout and Viewpager

        tabularViewPagerAdapter = new TabularViewPagerAdapter(this);
        productInformationFragView.setAdapter(tabularViewPagerAdapter);
        new TabLayoutMediator(tabLayout,productInformationFragView,(tab, position) -> tab.setText(titles[position])).attach();

        ////////////////////////////////////////

        ///// Product More Item Look like a Particular Product Recycler

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager
                (getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        moreRecycler.setLayoutManager(layoutManager);
        moreRecycler.setHasFixedSize(true);
        MoreProductAdapter moreProductAdapter = new MoreProductAdapter(str,getApplicationContext());
        moreRecycler.setAdapter(moreProductAdapter);


        /////////////////////////////////////////

        ////// Popular Product Item Recycler View

        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager
                (getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        popularRecycler.setLayoutManager(layoutManager1);
        popularRecycler.setHasFixedSize(true);
        PopularProductAdapter popularProductAdapter = new PopularProductAdapter(str,getApplicationContext());
        popularRecycler.setAdapter(popularProductAdapter);

        /////////////////////////////////////////
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}