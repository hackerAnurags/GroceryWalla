package com.hackeranushi.grocerywalla.ProfileActivity.Addresses;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.hackeranushi.grocerywalla.R;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import com.skydoves.elasticviews.ElasticButton;
import com.skydoves.elasticviews.ElasticImageView;

import java.io.IOException;
import java.security.PrivateKey;
import java.util.List;
import java.util.Locale;

public class AddAddress extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    boolean isPermissionGranted = true;
    private FusedLocationProviderClient mFusedLocation;
    private int GPS_REQUEST_CODE = 9001;

    EditText searchText;
    ElasticImageView searchButton;
    FloatingActionButton myLocation;
    TextView currentLocation;
    TextInputEditText name, houseNo, landMark, nickNameSociety;
    ElasticButton saveAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);

        searchText = findViewById(R.id.search_location_editText);
        searchButton = findViewById(R.id.search_button);
        myLocation = findViewById(R.id.my_location);
        currentLocation = findViewById(R.id.current_location);
        name = findViewById(R.id.addAddress_user_name);
        houseNo = findViewById(R.id.addAddress_house_no);
        landMark = findViewById(R.id.addAddress_society);
        nickNameSociety = findViewById(R.id.addAddress_location);
        saveAddress = findViewById(R.id.save_button);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("New Address");
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        saveAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String fullName = name.getText().toString();
                String house = houseNo.getText().toString();
                String society = landMark.getText().toString();
                String locationMark = nickNameSociety.getText().toString();

                if (!fullName.isEmpty() && !house.isEmpty() && !society.isEmpty()
                        && !locationMark.isEmpty()) {
                    Intent intent = new Intent(getApplicationContext(), MyAddress.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(AddAddress.this, "Enter all the fields", Toast.LENGTH_SHORT).show();
                }
            }
        });

        checkPermissionLocation();

        initiMap();

        mFusedLocation = new FusedLocationProviderClient(this);

        myLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getCurrentLocation();
                viewAddress();
            }
        });

        if (isPermissionGranted) {

            searchButton.setOnClickListener(this::geoLocate);
            viewAddress();
        }

    }


    private void viewAddress() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mFusedLocation.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                Location location = task.getResult();
                Geocoder geocoder = new Geocoder(AddAddress.this, Locale.getDefault());
                try {
                    List<Address> addressesList = geocoder.getFromLocation(location.getLatitude()
                            , location.getLongitude(), 1);

                    currentLocation.setText(addressesList.get(0).getAddressLine(0));

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });    }

    private void geoLocate(View view) {

        String locationName = searchText.getText().toString();
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());

        try {
            List<Address> addressesList = geocoder.getFromLocationName(locationName, 1);

            if (addressesList.size() > 0) {
                Address address = addressesList.get(0);
                getLocation(address.getLatitude(), address.getLongitude());
                mMap.addMarker(new MarkerOptions().position(new LatLng(address.getLatitude(), address.getLongitude())));
                currentLocation.setText(addressesList.get(0).getAddressLine(0));
                Toast.makeText(AddAddress.this, address.getLocality(), Toast.LENGTH_SHORT).show();
            }

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    private void initiMap() {

        if (isPermissionGranted) {

            if (gpsIsEnable()) {
                SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
                supportMapFragment.getMapAsync(this);
            }
        }
    }

    private boolean gpsIsEnable() {
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        boolean providerEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

        if (providerEnabled) {
            return true;
        } else {
            AlertDialog alertDialog = new AlertDialog.Builder(this)
                    .setTitle("Gps Permission")
                    .setMessage("Gps is required, please enable the gps")
                    .setPositiveButton("yes", (dialogInterface, i) -> {
                        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivityForResult(intent, GPS_REQUEST_CODE);
                    }).setCancelable(false)
                    .show();
        }

        return false;
    }

    @SuppressLint("MissingPermission")
    private void getCurrentLocation() {

        mFusedLocation.getLastLocation().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Location location = task.getResult();
                if (location != null) {

                    getLocation(location.getLatitude(), location.getLongitude());
                }
            }
        });

    }

    private void getLocation(double latitude, double longitude) {

        LatLng latLong = new LatLng(latitude, longitude);

        MarkerOptions markerOptions = new MarkerOptions().position(latLong).title("You are here");

        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLong, 14);
        mMap.moveCamera(cameraUpdate);
        mMap.addMarker(markerOptions);
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }

    //// this is the permission dialog

    private void checkPermissionLocation() {

        Dexter.withContext(this).withPermission
                (Manifest.permission.ACCESS_FINE_LOCATION).withListener
                (new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                        Toast.makeText(AddAddress.this, "Permission is Granted", Toast.LENGTH_SHORT).show();
                        isPermissionGranted = true;

                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                        Intent intent = new Intent();
                        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                        Uri uri = Uri.fromParts("package", getPackageName(), "");
                        intent.setData(uri);
                        startActivity(intent);

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {

                        permissionToken.continuePermissionRequest();

                    }
                }).check();
    }

    ///////////////

    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        mMap = googleMap;
//        mMap.setMyLocationEnabled(true);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GPS_REQUEST_CODE) {
            LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
            boolean providerEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

            if (providerEnabled) {
                Toast.makeText(AddAddress.this, "Gps is enable", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Gps is not enable", Toast.LENGTH_SHORT).show();
            }

        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
