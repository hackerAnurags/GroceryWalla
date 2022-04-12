package com.hackeranushi.grocerywalla.ProductDetails;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.hackeranushi.grocerywalla.DeliveryActivity.DeliveryActivity;
import com.hackeranushi.grocerywalla.Helper.Constaints;
import com.hackeranushi.grocerywalla.Helper.GroceryConst;
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

import java.util.ArrayList;

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
    String id,category_prod_id ;
    int recyclerviewPosition,categoryRecyclerviewPosition;
    private FirebaseFirestore firebaseFirestore;
    private FirebaseAuth mAuth;
    private String mid, w_name,w_price, w_cut_price,w_img,w_unit;

    private TextView product_name,product_price,cut_price,
            percent_offer,unit_density,product_offer_price;



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

        firebaseFirestore=FirebaseFirestore.getInstance();
        mAuth=FirebaseAuth.getInstance();
        Constaints.current_user=mAuth.getUid();
        Log.d("currentuser",Constaints.current_user);

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

        product_name = findViewById(R.id.product_detail_product_name);
        product_price = findViewById(R.id.product_detail_product_price);
        cut_price = findViewById(R.id.product_detail_cut_price);
        unit_density = findViewById(R.id.product_detail_unit_density);
        product_offer_price = findViewById(R.id.product_offer_price);

        /// Navigate data from another activity to this activity

        Intent i = getIntent();
        id = i.getStringExtra("id");
        Constaints.product_id = id;
        Log.d("product_id", "product Id  "+Constaints.product_id);

        Intent recyclerintent=getIntent();
        recyclerviewPosition=recyclerintent.getIntExtra("recyclerview_position",0);
        Constaints.recycler_position=recyclerviewPosition;
        Log.d("checkData.......","Recycler Position"+Constaints.recycler_position);

        Intent selection=getIntent();
        int select=selection.getIntExtra("SELECTION",0);
        Constaints.selection_position = select;
        Log.d("checkData.......","Selection Position"+Constaints.selection_position);

        ///////////////////////////////////////////////////////////////////

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


        //////get data and call product details from home activity

        if (Constaints.recycler_position==1) {
            Log.d("recycler_position",""+Constaints.recycler_position);
            getProductDetails("ProductList", "Fruits & Vegetables", Constaints.product_id);
        }
        else if (Constaints.recycler_position==2){
            Log.d("recycler_position",""+Constaints.recycler_position);
            getProductDetails("ProductList", "Snacks", Constaints.product_id);

        }
        else if (Constaints.recycler_position==3){
            Log.d("recycler_position",""+Constaints.recycler_position);
            getProductDetails("ProductList", "BakeryProducts", Constaints.product_id);

        }
        else if (Constaints.recycler_position==4){
            Log.d("recycler_position",""+Constaints.recycler_position);
            getProductDetails("ProductList", "TeaCoffee", Constaints.product_id);

        }
        else if (Constaints.recycler_position==5){
            Log.d("recycler_position",""+Constaints.recycler_position);
            getProductDetails("ProductList", "ColdDrinks", Constaints.product_id);

        }
        else if (Constaints.recycler_position==6){
            Log.d("recycler_position",""+Constaints.recycler_position);
            getProductDetails("ProductList", "Grocery", Constaints.product_id);

        }
        else if (Constaints.recycler_position==7){
            Log.d("recycler_position",""+Constaints.recycler_position);
            getProductDetails("ProductList", "Masala", Constaints.product_id);

        }
        else if (Constaints.recycler_position==8){
            Log.d("recycler_position",""+Constaints.recycler_position);
            getProductDetails("ProductList", "BabyCare", Constaints.product_id);

        }
        else if (Constaints.recycler_position==9){
            Log.d("recycler_position",""+Constaints.recycler_position);
            getProductDetails("ProductList", "PersonalCare", Constaints.product_id);

        }
        else if (Constaints.recycler_position==10){
            Log.d("recycler_position",""+Constaints.recycler_position);
            getProductDetails("ProductList", "Cleaning", Constaints.product_id);

        }
        else if (Constaints.recycler_position==11){
            Log.d("recycler_position",""+Constaints.recycler_position);
            getProductDetails("ProductList", "PetCare", Constaints.product_id);

        }


        ///////////////////////////////////////////////////////////

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

    private void getProductDetails(String p_doc, String p_collection, String id) {

        firebaseFirestore.collection("HomeProducts").document(p_doc).collection(p_collection).document(id).get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {

                            DocumentSnapshot documentSnapshot = task.getResult();
                            mid = documentSnapshot.getString("id");
                            documentSnapshot.getString("p_country");
                            documentSnapshot.getString("p_customer_care");
                            w_cut_price = documentSnapshot.getString("p_cut_price");
                            cut_price.setText(documentSnapshot.getString("p_cut_price"));
                            documentSnapshot.getString("p_desc");
                            documentSnapshot.getString("p_disclaimer");
                            documentSnapshot.getString("p_img");
                            documentSnapshot.getString("p_index");
                            documentSnapshot.getString("p_ingredients");
                            documentSnapshot.getString("p_key");
                            documentSnapshot.getString("p_manufacture");
                            documentSnapshot.getString("p_marked_by");
                            product_name.setText(documentSnapshot.getString("p_name"));
                            documentSnapshot.getString("p_nutrition");
                            product_offer_price.setText(documentSnapshot.getString("p_offer"));
                            product_price.setText(documentSnapshot.getString("p_price"));
                            documentSnapshot.getString("p_rating");
                            documentSnapshot.getString("p_seller");
                            documentSnapshot.getString("p_shelf_life");
                            unit_density.setText(documentSnapshot.getString("p_unit"));
                        }
                    }
                });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}