package com.hackeranushi.grocerywalla.ProfileActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.hackeranushi.grocerywalla.R;
import com.ramotion.circlemenu.CircleMenuView;

public class Setting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Setting");
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        final CircleMenuView menu = findViewById(R.id.circle_menu);
        menu.setEventListener(new CircleMenuView.EventListener(){
            @Override
            public void onMenuOpenAnimationStart(@NonNull CircleMenuView view) {

            }
            @Override
            public void onMenuOpenAnimationEnd(@NonNull CircleMenuView view) {

            }
            @Override
            public void onMenuCloseAnimationStart(@NonNull CircleMenuView view) {

            }
            @Override
            public void onMenuCloseAnimationEnd(@NonNull CircleMenuView view) {

            }
            @Override
            public void onButtonClickAnimationStart(@NonNull CircleMenuView view, int index) {

                switch (index)
                {
//                    case 0:
//                        Intent intent = new Intent(getApplicationContext(), ShowDialog.class);
//                        startActivity(intent);
//                    case 1:
//                        Intent intent1 = new Intent(getApplicationContext(), ButtonClick.class);
//                        startActivity(intent1);
//                    case 2:
//                        Toast.makeText(Setting.this, "DashBoard", Toast.LENGTH_SHORT).show();
//                    case 3:
//                        Toast.makeText(Setting.this, "Home", Toast.LENGTH_SHORT).show();
//                    case 4:
//                        Toast.makeText(Setting.this, "Notification", Toast.LENGTH_SHORT).show();
                }

            }
            @Override
            public void onButtonClickAnimationEnd(@NonNull CircleMenuView view, int index) {

            }
            @Override
            public boolean onButtonLongClick(@NonNull CircleMenuView view, int buttonIndex) {

                return true;
            }
            @Override
            public void onButtonLongClickAnimationStart(@NonNull CircleMenuView view, int buttonIndex) {

            }
            @Override
            public void onButtonLongClickAnimationEnd(@NonNull CircleMenuView view, int buttonIndex) {

            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}