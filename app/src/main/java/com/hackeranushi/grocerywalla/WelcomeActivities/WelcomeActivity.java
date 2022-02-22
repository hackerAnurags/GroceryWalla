package com.hackeranushi.grocerywalla.WelcomeActivities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

import com.hackeranushi.grocerywalla.Helper.Internet;
import com.hackeranushi.grocerywalla.R;

import java.util.ArrayList;
import java.util.List;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        go_next();

    }

    private void go_next() {

        if (!Internet.isNetAvailable(WelcomeActivity.this)) {
            AlertDialog dialog = new AlertDialog.Builder(this)
                    .setTitle("Internet Not Found!")
                    .setMessage("\nPlease check your internet connection?")
                    .setIcon(R.drawable.ic_no_internet)
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    }).show();


        } else {

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

    private boolean checkAndRequestPermissions() {

        int READ_CONTACTS = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS);

        int Coarsepermission = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION);
        int permissionLocation = ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION);
        int readStorage =ContextCompat.checkSelfPermission(this,Manifest.permission.READ_EXTERNAL_STORAGE);
        int call = ContextCompat.checkSelfPermission(this,Manifest.permission.CALL_PHONE);

        List<String> listPermissionsNeeded = new ArrayList<>();

        if (Coarsepermission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.ACCESS_COARSE_LOCATION); }

        if (permissionLocation != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.ACCESS_FINE_LOCATION); }

        if (readStorage != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.READ_PHONE_STATE);
        }
        if (call != PackageManager.PERMISSION_GRANTED)
        { listPermissionsNeeded.add(Manifest.permission.CALL_PHONE); }

        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this,
                    listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]),
                    1011);
            return false;
        }
        else
        {
            go_next();
        }
        return true;
    }

    private boolean hasPermission(Context context, String[] permissions) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q && context != null && permissions != null)
        {
            for (String permission : permissions)
            {
                if (ActivityCompat.checkSelfPermission(context , permission) != PackageManager.PERMISSION_GRANTED)
                    return false;
            }
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1011) {
            {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    go_next();
                } else {
                    go_next();
                }
            }
        }
    }
}