package com.hackeranushi.grocerywalla.MenuActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.hackeranushi.grocerywalla.MenuActivity.Adapter.NewProductAdapter;
import com.hackeranushi.grocerywalla.R;

public class NewProductHomepage extends AppCompatActivity {

    RecyclerView newRecycler;
    String[] str=new String[]{"","","","","","","","","","",""};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_product_homepage);

        newRecycler = findViewById(R.id.new_product_recycler);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("New Products");
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),3);
        newRecycler.setLayoutManager(layoutManager);
        newRecycler.setHasFixedSize(true);
        NewProductAdapter newProductAdapter = new NewProductAdapter(str,getApplicationContext());
        newRecycler.setAdapter(newProductAdapter);
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}