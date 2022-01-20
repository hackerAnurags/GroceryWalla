package com.hackeranushi.grocerywalla.ProfileActivity.CustomerSupport;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ExpandableListView;

import com.hackeranushi.grocerywalla.ProfileActivity.CustomerSupport.expandableAdapter.CancellationQueryAdapter;
import com.hackeranushi.grocerywalla.ProfileActivity.CustomerSupport.expandableAdapter.DeliveryQueryAdapter;
import com.hackeranushi.grocerywalla.ProfileActivity.CustomerSupport.expandableAdapter.GeneralQueryAdapter;
import com.hackeranushi.grocerywalla.ProfileActivity.CustomerSupport.expandableAdapter.PaymentQueryAdapter;
import com.hackeranushi.grocerywalla.ProfileActivity.CustomerSupport.expandableAdapter.PlacingQueryAdapter;
import com.hackeranushi.grocerywalla.R;
import com.skydoves.elasticviews.ElasticButton;

public class CustomerSupport extends AppCompatActivity {

    EditText emailCustomer,fullNameCustomer,cityCustomer;
    ElasticButton save;
    ExpandableListView payment, delivery, cancellation, general, placing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_support);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Customer Support");
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        emailCustomer = findViewById(R.id.email);
        fullNameCustomer = findViewById(R.id.fullName);
        cityCustomer = findViewById(R.id.city);
        save = findViewById(R.id.save);
        payment = findViewById(R.id.paymentExpandable);
        delivery = findViewById(R.id.deliveryExpandable);
        cancellation = findViewById(R.id.cancellationExpandable);
        general = findViewById(R.id.generalExpandable);
        placing = findViewById(R.id.placingExpandable);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailCustomer.getText().toString();
                String fullName = fullNameCustomer.getText().toString();
                String city = cityCustomer.getText().toString();

                if (!email.isEmpty() && !fullName.isEmpty() && !city.isEmpty())
                {
                    Intent intent = new Intent();
                    intent.putExtra("Email",email);
                    intent.putExtra("FullName",fullName);
                    intent.putExtra("City",city);
                }
            }
        });

        PaymentQueryAdapter paymentQueryAdapter = new PaymentQueryAdapter(getApplicationContext());
        payment.setAdapter(paymentQueryAdapter);

        DeliveryQueryAdapter deliveryQueryAdapter = new DeliveryQueryAdapter(getApplicationContext());
        delivery.setAdapter(deliveryQueryAdapter);

        GeneralQueryAdapter generalQueryAdapter = new GeneralQueryAdapter(getApplicationContext());
        general.setAdapter(generalQueryAdapter);

        CancellationQueryAdapter cancellationQueryAdapter = new CancellationQueryAdapter(getApplicationContext());
        cancellation.setAdapter(cancellationQueryAdapter);

        PlacingQueryAdapter placingQueryAdapter = new PlacingQueryAdapter(getApplicationContext());
        placing.setAdapter(placingQueryAdapter);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}