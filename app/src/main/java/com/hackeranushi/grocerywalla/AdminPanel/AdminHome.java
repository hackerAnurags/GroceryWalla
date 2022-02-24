package com.hackeranushi.grocerywalla.AdminPanel;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.hackeranushi.grocerywalla.Activities.Register;
import com.hackeranushi.grocerywalla.Helper.GroceryConst;
import com.hackeranushi.grocerywalla.R;
import com.hackeranushi.grocerywalla.databinding.ActivityAdminHomeBinding;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;


public class AdminHome extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityAdminHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAdminHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarAdminHome.toolbar);
//        binding.appBarAdminHome.fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_adHome, R.id.nav_category, R.id.nav_banner, R.id.nav_fruits,R.id.nav_snacks
        , R.id.nav_bakery, R.id.nav_tea_coffee,R.id.nav_cold_drinks,R.id.nav_grocery_items,R.id.nav_masala
        ,R.id.nav_baby_care,R.id.nav_personal_care,R.id.nav_cleaning,R.id.nav_pet_care)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_admin_home);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.admin_home, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_admin_home);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.navdrawer_logout:
                AlertDialog.Builder dialog = new AlertDialog.Builder(AdminHome.this);
                dialog.setTitle("Logout!");
                dialog.setMessage("\nDo you want to logout IPOS?");
                dialog.setIcon(R.drawable.ic_grocery_logout);
                dialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        GroceryConst.sharedPreferences.edit().clear().apply();
                        Intent intent = new Intent(AdminHome.this, Register.class);
                        startActivity(intent);
                        finish();
                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog alertDialog = dialog.create();
                alertDialog.show();
                break;
        }
        return NavigationUI.onNavDestinationSelected(item,Navigation.
                findNavController(this, R.id.nav_host_fragment_content_admin_home))
                || super.onOptionsItemSelected(item);
    }
}