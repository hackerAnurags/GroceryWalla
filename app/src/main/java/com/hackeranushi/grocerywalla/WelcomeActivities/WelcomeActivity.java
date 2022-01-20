package com.hackeranushi.grocerywalla.WelcomeActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.hackeranushi.grocerywalla.R;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (WelcomeActivity.this == null)
                {
                    return;
                }else
                {
                    Intent intent = new Intent(getApplicationContext(),Starer.class);
                    startActivity(intent);
                    finish();
                }

            }
        },3000);
    }
}