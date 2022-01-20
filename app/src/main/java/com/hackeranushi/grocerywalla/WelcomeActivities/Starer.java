package com.hackeranushi.grocerywalla.WelcomeActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hackeranushi.grocerywalla.Activities.Authentication;
import com.hackeranushi.grocerywalla.Adapter.StarerViewPagerAdapter;
import com.hackeranushi.grocerywalla.R;
import com.skydoves.elasticviews.ElasticButton;

import me.relex.circleindicator.CircleIndicator;

public class Starer extends AppCompatActivity {

    ViewPager viewPage;
    CircleIndicator circleIndicator;
    ElasticButton getStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starer);

        viewPage=findViewById(R.id.viewpage1);
        circleIndicator=findViewById(R.id.indicator);
        getStart=findViewById(R.id.getstart);

        StarerViewPagerAdapter viewPagerAdapter = new StarerViewPagerAdapter(getApplicationContext());
        viewPage.setAdapter(viewPagerAdapter);
        circleIndicator.setViewPager(viewPage);

        getStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), Authentication.class);
                startActivity(intent);
            }
        });
    }
}