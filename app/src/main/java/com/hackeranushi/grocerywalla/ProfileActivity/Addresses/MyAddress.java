package com.hackeranushi.grocerywalla.ProfileActivity.Addresses;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.hackeranushi.grocerywalla.R;

public class MyAddress extends AppCompatActivity {

    Toolbar toolbar;
    LinearLayout changeAddress;
    RecyclerView showRecycler;
    AddressAdapter addressAdapter;
    String[] str=new String[]{"","","",""};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_address);

        toolbar =  findViewById(R.id.toolbar);
        changeAddress = findViewById(R.id.change_address);
        showRecycler = findViewById(R.id.showAddress_recycler);

        changeAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AddAddress.class);
                startActivity(intent);
            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        showRecycler.setLayoutManager(layoutManager);
        showRecycler.setHasFixedSize(true);
        addressAdapter = new AddressAdapter(str,getApplicationContext());
        showRecycler.setAdapter(addressAdapter);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("My Address");
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}