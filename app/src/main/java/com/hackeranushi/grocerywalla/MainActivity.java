package com.hackeranushi.grocerywalla;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationBarView;
import com.hackeranushi.grocerywalla.FragmentHome.CartFragment;
import com.hackeranushi.grocerywalla.FragmentHome.HomeFragment;
import com.hackeranushi.grocerywalla.FragmentHome.OrderFragment;
import com.hackeranushi.grocerywalla.FragmentHome.ProfileFragment;
import com.hackeranushi.grocerywalla.MenuActivity.NewProductHomepage;
import com.hackeranushi.grocerywalla.MenuActivity.NotificationHomepage;
import com.hackeranushi.grocerywalla.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;
    private ImageView actionBarLogo;
    Toolbar toolbar;
    boolean check = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        BottomNavigationView navView = findViewById(R.id.nav_view);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        actionBarLogo = findViewById(R.id.actionBarLogo);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayShowTitleEnabled(false);
//
//        setFragment(new HomeFragment(), HOME_FRAGMENT);
//        binding.navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        binding.navView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                int id = item.getItemId();
//                if (id == R.id.navigation_home) {
//                    actionBarLogo.setVisibility(View.VISIBLE);
//                    invalidateOptionsMenu();
//                    setFragment(new HomeFragment(), HOME_FRAGMENT);
//
//                } else if (id == R.id.navigation_cart) {
//                    setFragment(new CartFragment(), CART_FRAGMENT);
//                    actionBarLogo.setVisibility(View.GONE);
//                    getSupportActionBar().setDisplayShowTitleEnabled(true);
//                    getSupportActionBar().setTitle("My Order");
//
//                } else if (id == R.id.navigation_order) {
//                    setFragment(new OrderFragment(), ORDER_FRAGMENT);
//                    actionBarLogo.setVisibility(View.GONE);
//                    getSupportActionBar().setDisplayShowTitleEnabled(true);
//                    getSupportActionBar().setTitle("My Cart");
//                }else if (id == R.id.navigation_profile) {
//                    setFragment(new ProfileFragment(), PROFILE_FRAGMENT);
//                    actionBarLogo.setVisibility(View.GONE);
//                    getSupportActionBar().setDisplayShowTitleEnabled(true);
//                    getSupportActionBar().setTitle("My Cart");
//                }
//                return false;
//            }
//        });

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_cart, R.id.navigation_order, R.id.navigation_profile)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        actionBarLogo = findViewById(R.id.actionBarLogo);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        NavigationUI.setupWithNavController(toolbar,navController,appBarConfiguration);

        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller,
                                             @NonNull NavDestination destination, @Nullable Bundle arguments) {

                if(destination.getId() == R.id.navigation_home) {
                    toolbar.setVisibility(View.VISIBLE);
                    actionBarLogo.setVisibility(View.VISIBLE);
                    getSupportActionBar().setDisplayShowTitleEnabled(false);

                } else if (destination.getId() == R.id.navigation_cart){
                    toolbar.setVisibility(View.VISIBLE);
                    actionBarLogo.setVisibility(View.GONE);
                    getSupportActionBar().setTitle("My Cart");
                    getSupportActionBar().setDisplayShowTitleEnabled(true);

                }else if (destination.getId() == R.id.navigation_order){
                    toolbar.setVisibility(View.VISIBLE);
                    actionBarLogo.setVisibility(View.GONE);
                    getSupportActionBar().setTitle("My Order");
                    getSupportActionBar().setDisplayShowTitleEnabled(true);


                }else if (destination.getId() == R.id.navigation_profile){
                    toolbar.setVisibility(View.VISIBLE);
                    actionBarLogo.setVisibility(View.GONE);
                    getSupportActionBar().setTitle("Profile");
                    getSupportActionBar().setDisplayShowTitleEnabled(true);

                }
            }
        });
    }

//
//    private void setFragment(Fragment fragment, int fragmentNo) {
//        if (fragmentNo != currentFragment) {
//            currentFragment = fragmentNo;
//            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//            fragmentTransaction.replace(R.id.nav_host_fragment_activity_main, fragment);
//            fragmentTransaction.commit();
//        }
//
//    @Override
//    public void onBackPressed() {
//        backButton();
//    }
//
//    private void backButton() {
//        if (currentFragment == HOME_FRAGMENT) {
////            new AlertDialog.Builder(this)
////                    .setTitle("Message")
////                    .setMessage("Do you want to exist")
////                    .setNegativeButton("No", null)
////                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
////                        @Override
////                        public void onClick(DialogInterface dialogInterface, int i) {
////                            finishAffinity();
////                            System.exit(0);
////                        }
////                    }).create().show();
//            super.onBackPressed();
//
//        } else {
//            invalidateOptionsMenu();
//            setFragment(new HomeFragment(), HOME_FRAGMENT);
//            binding.navView.getMenu().getItem(0).setChecked(true);
//        }
//    }
//
//

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//            getSupportActionBar().setDisplayShowTitleEnabled(false);
//            getMenuInflater().inflate(R.menu.toolbar_icon,menu);
//        NavController navController = Navigation.findNavController(MainActivity.this,R.id.navigation_home);

        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.toolbar_icon, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.homepage_notification_icon)
        {
            Intent notificationIntent = new Intent(getApplicationContext(), NotificationHomepage.class);
            startActivity(notificationIntent);
            return true;
        }else if (id == R.id.homepage_newProduct_icon)
        {
            Intent newProductIntent = new Intent(getApplicationContext(), NewProductHomepage.class);
            startActivity(newProductIntent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}