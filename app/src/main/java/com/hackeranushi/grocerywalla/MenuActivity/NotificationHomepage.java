package com.hackeranushi.grocerywalla.MenuActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.hackeranushi.grocerywalla.MainActivity;
import com.hackeranushi.grocerywalla.MenuActivity.Adapter.NotificationAdapter;
import com.hackeranushi.grocerywalla.R;

public class NotificationHomepage extends AppCompatActivity {
    RecyclerView recyclerView;
    String[] str=new String[]{"","","","","","","","","","",""};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_homepage);
        recyclerView = findViewById(R.id.notification_recycler);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Notifications");
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        NotificationAdapter notificationAdapter = new NotificationAdapter(str,getApplicationContext());
        recyclerView.setAdapter(notificationAdapter);
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}