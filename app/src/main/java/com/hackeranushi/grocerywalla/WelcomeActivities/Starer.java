package com.hackeranushi.grocerywalla.WelcomeActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.hackeranushi.grocerywalla.Activities.Register;
import com.hackeranushi.grocerywalla.Adapter.StarerViewPagerAdapter;
import com.hackeranushi.grocerywalla.AdminPanel.AdminHome;
import com.hackeranushi.grocerywalla.Helper.GroceryConst;
import com.hackeranushi.grocerywalla.MainActivity;
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

        GroceryConst.sharedPreferences = getSharedPreferences(GroceryConst.sp_name, MODE_PRIVATE);
        GroceryConst.editor = GroceryConst.sharedPreferences.edit();
        String name = GroceryConst.sharedPreferences.getString(GroceryConst.OtpKeys.USER_NAME,"");
        Log.d("checkUser",name);
        viewPage=findViewById(R.id.viewpage1);
        circleIndicator=findViewById(R.id.indicator);
        getStart=findViewById(R.id.getstart);

        StarerViewPagerAdapter viewPagerAdapter = new StarerViewPagerAdapter(getApplicationContext());
        viewPage.setAdapter(viewPagerAdapter);
        circleIndicator.setViewPager(viewPage);

        getStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (GroceryConst.sharedPreferences.contains(GroceryConst.OtpKeys.UID)
                        ||GroceryConst.sharedPreferences.contains(GroceryConst.EmailKeys.UID))
                {
                    Log.d("CheckData...",GroceryConst.sharedPreferences.getString(GroceryConst.OtpKeys.UID,""));
                    Intent intent=new Intent(getApplicationContext(), AdminHome.class);
                    startActivity(intent);
                }
                else if (GroceryConst.sharedPreferences.contains(GroceryConst.adminKey.UID))
                {
                    Intent intent=new Intent(getApplicationContext(), AdminHome.class);
                    startActivity(intent);
                }
                else
                {
                    Intent intent=new Intent(getApplicationContext(), Register.class);
                    startActivity(intent);
                }
            }
        });
    }
}