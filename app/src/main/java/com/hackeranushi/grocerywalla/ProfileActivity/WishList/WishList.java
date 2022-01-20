package com.hackeranushi.grocerywalla.ProfileActivity.WishList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.hackeranushi.grocerywalla.MenuActivity.Adapter.NewProductAdapter;
import com.hackeranushi.grocerywalla.R;

public class WishList extends AppCompatActivity {

    RecyclerView wishList;
    String[] str=new String[]{"","","","","","","","","","",""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish_list);

        wishList = findViewById(R.id.wishlist);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("WishList");
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        wishList.setLayoutManager(layoutManager);
        wishList.setHasFixedSize(true);
        WishListAdapter wishListAdapter = new WishListAdapter(str,getApplicationContext());
        wishList.setAdapter(wishListAdapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}