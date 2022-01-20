package com.hackeranushi.grocerywalla.DeliveryActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.hackeranushi.grocerywalla.Activities.PaymentOption;
import com.hackeranushi.grocerywalla.ProfileActivity.Addresses.AddAddress;
import com.hackeranushi.grocerywalla.R;
import com.skydoves.elasticviews.ElasticButton;

public class DeliveryActivity extends AppCompatActivity {

    LinearLayout paymentOption;
    RecyclerView deliveryRecycler;
    String[] str=new String[]{"","","","","","","","","","",""};
    ElasticButton changeAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);

        paymentOption = findViewById(R.id.payment_option);
        deliveryRecycler = findViewById(R.id.delivery_recyclerview);
        changeAddress = findViewById(R.id.change_address);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Delivery");
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        RecyclerView.LayoutManager layoutManager = new  LinearLayoutManager(getApplicationContext());
        deliveryRecycler.setLayoutManager(layoutManager);
        DeliveryAdapter deliveryAdapter = new DeliveryAdapter(str,getApplicationContext());
        deliveryRecycler.setAdapter(deliveryAdapter);
        deliveryRecycler.setHasFixedSize(true);

        changeAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddAddress.class);
                startActivity(intent);
            }
        });


        paymentOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PaymentOption.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}