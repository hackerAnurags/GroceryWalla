package com.hackeranushi.grocerywalla.FragmentHome;

import static android.content.Context.MODE_PRIVATE;

import static com.hackeranushi.grocerywalla.Helper.ExtraUtils.checkPermissionLocation;
import static com.hackeranushi.grocerywalla.Helper.GroceryConst.locationGet;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.hackeranushi.grocerywalla.Activities.Category;
import com.hackeranushi.grocerywalla.Helper.GroceryConst;
import com.hackeranushi.grocerywalla.HomeProductAdapter.CategoryAdapter;
import com.hackeranushi.grocerywalla.HomeProductAdapter.HomeAdapter;
import com.hackeranushi.grocerywalla.HomeProductAdapter.HomeViewAdapter;
import com.hackeranushi.grocerywalla.HomeProductAdapter.NoDataAdapter;
import com.hackeranushi.grocerywalla.HomeProductModel.HomeModel;
import com.hackeranushi.grocerywalla.Models.HomeModel.CategoryModel;
import com.hackeranushi.grocerywalla.Models.HomeModel.ProductModel;
import com.hackeranushi.grocerywalla.ProfileActivity.Addresses.AddAddress;
import com.hackeranushi.grocerywalla.R;
import com.skydoves.elasticviews.ElasticButton;
import com.skydoves.elasticviews.ElasticImageView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import me.relex.circleindicator.CircleIndicator;

public class HomeFragment extends Fragment {

    RecyclerView categoryRecycler,fruitsRecycler,snacksRecycler,fourthRecycler,fifthRecycler,sixthRecycler
            ,seventhRecycler,eightRecycler,ninthRecycler,tenthRecycler;
    ViewPager homeHeaderViewPager;
    CircleIndicator indicator;
    ElasticButton category;
    ImageView locationButton;
    private FirebaseFirestore firebaseFirestore;

    private FusedLocationProviderClient mFusedLocation;
    private int GPS_REQUEST_CODE = 9001;

    private ArrayList<CategoryModel> catList;
    private ArrayList<ProductModel> fruitsModel;
    private ArrayList<ProductModel> snacksModel;
    private ArrayList<HomeModel> homeModels3;
    private ArrayList<HomeModel> homeModels4;
    private ArrayList<HomeModel> homeModels5;
    private ArrayList<HomeModel> homeModels6;
    private ArrayList<HomeModel> homeModels7;
    private ArrayList<HomeModel> homeModels8;
    private ArrayList<HomeModel> homeModels9;
    String[] str=new String[]{"","",""};
    HomeAdapter homeAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        init(view);
        firebaseFirestore=FirebaseFirestore.getInstance();

        categoryRecycler=view.findViewById(R.id.categoryRecycler);
        fruitsRecycler=view.findViewById(R.id.secondRecycle);
        snacksRecycler=view.findViewById(R.id.thirdRecycle);
        fourthRecycler=view.findViewById(R.id.forthRecycle);
        fifthRecycler=view.findViewById(R.id.fifthRecycle);
        sixthRecycler=view.findViewById(R.id.sixthRecycle);
        seventhRecycler=view.findViewById(R.id.seventhRecycle);
        eightRecycler=view.findViewById(R.id.eightRecycle);
        ninthRecycler=view.findViewById(R.id.ninthRecycle);
        tenthRecycler=view.findViewById(R.id.tenthRecycle);
        homeHeaderViewPager = view.findViewById(R.id.home_viewpager);
        indicator = view.findViewById(R.id.indicator2);
        category = view.findViewById(R.id.category);

        GroceryConst.sharedPreferences = requireActivity().getSharedPreferences(GroceryConst.sp_name, MODE_PRIVATE);
        GroceryConst.editor = GroceryConst.sharedPreferences.edit();



        HomeViewAdapter homeViewAdapter =new HomeViewAdapter(getActivity());
        homeHeaderViewPager.setAdapter(homeViewAdapter);
        indicator.setViewPager(homeHeaderViewPager);

        ////category Recycler
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(),3);
        categoryRecycler.setLayoutManager(layoutManager);
        categoryRecycler.setHasFixedSize(true);
        catList = new ArrayList<>();

        /////firebase path

        firebaseFirestore.collection("CATEGORIES").orderBy("index").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @SuppressLint("NotifyDataSetChanged")
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            for (QueryDocumentSnapshot documentSnapshot : task.getResult()){
                                catList.add(new CategoryModel(Objects.requireNonNull(documentSnapshot.get("cat_img"))
                                        .toString(), Objects.requireNonNull(documentSnapshot.get("cat_name")).toString()));
                            }
                            if (!(catList.size() ==0))
                            {
                                CategoryAdapter catAdapter = new CategoryAdapter(catList,getContext());
                                categoryRecycler.setAdapter(catAdapter);
                                catAdapter.notifyDataSetChanged();
                            }else
                            {
                                NoDataAdapter noDataAdapter = new NoDataAdapter(str,getContext());
                                categoryRecycler.setAdapter(noDataAdapter);
                                noDataAdapter.notifyDataSetChanged();
                                Toast.makeText(getActivity(), "Sorry there are no data", Toast.LENGTH_SHORT).show();
                            }

                        }else {
                            String error=task.getException().getMessage();
                            Toast.makeText(getActivity(),error, Toast.LENGTH_SHORT).show();
                        }
                    }
                });

        //////////end firebase recycler impliment//

        ////end cat Recycler


        /////home recycler
        RecyclerView.LayoutManager fruitsLayout=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        fruitsRecycler.setLayoutManager(fruitsLayout);
        fruitsRecycler.setHasFixedSize(true);
        fruitsModel = new ArrayList<>();
        getProducts(0,"ProductList","Fruits & Vegetables");

        RecyclerView.LayoutManager snackLayout=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        snacksRecycler.setLayoutManager(snackLayout);
        snacksRecycler.setHasFixedSize(true);
        snacksModel = new ArrayList<>();
        getProducts(1,"ProductList","Snacks");

//        homeAdapter=new HomeAdapter(2,str,getContext());
//        thirdRecycler.setAdapter(homeAdapter);

        RecyclerView.LayoutManager layoutManager3=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        fourthRecycler.setLayoutManager(layoutManager3);
        fourthRecycler.setHasFixedSize(true);
//        homeModels3 = new ArrayList<>();
//        homeAdapter=new HomeAdapter(3,str,getContext());
//        fourthRecycler.setAdapter(homeAdapter);

        RecyclerView.LayoutManager layoutManager4=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        fifthRecycler.setLayoutManager(layoutManager4);
        fifthRecycler.setHasFixedSize(true);
//        homeModels4 = new ArrayList<>();
//        homeAdapter=new HomeAdapter(4,str,getContext());
//        fifthRecycler.setAdapter(homeAdapter);

        RecyclerView.LayoutManager layoutManager5=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        sixthRecycler.setLayoutManager(layoutManager5);
        sixthRecycler.setHasFixedSize(true);
//        homeModels5 = new ArrayList<>();
//        homeAdapter=new HomeAdapter(5,str,getContext());
//        sixthRecycler.setAdapter(homeAdapter);

        RecyclerView.LayoutManager layoutManager6=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        seventhRecycler.setLayoutManager(layoutManager6);
        seventhRecycler.setHasFixedSize(true);
//        homeModels6 = new ArrayList<>();
//        homeAdapter=new HomeAdapter(6,str,getContext());
//        seventhRecycler.setAdapter(homeAdapter);

        RecyclerView.LayoutManager layoutManager7=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        eightRecycler.setLayoutManager(layoutManager7);
        eightRecycler.setHasFixedSize(true);
//        homeModels7 = new ArrayList<>();
//        homeAdapter=new HomeAdapter(7,str,getContext());
//        eightRecycler.setAdapter(homeAdapter);

        RecyclerView.LayoutManager layoutManager8=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        ninthRecycler.setLayoutManager(layoutManager8);
        ninthRecycler.setHasFixedSize(true);
//        homeModels8 = new ArrayList<>();
//        homeAdapter=new HomeAdapter(8,str,getContext());
//        ninthRecycler.setAdapter(homeAdapter);

        RecyclerView.LayoutManager layoutManager9=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        tenthRecycler.setLayoutManager(layoutManager9);
        tenthRecycler.setHasFixedSize(true);
//        homeModels9 = new ArrayList<>();
//        homeAdapter=new HomeAdapter(9,str,getContext());
//        tenthRecycler.setAdapter(homeAdapter);
        return view;
    }

    private void getProducts(final int pos, final String p_doc, final String p_collection) {

        firebaseFirestore.collection("HomeProducts").document(p_doc).collection(p_collection).orderBy("p_index").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @SuppressLint("NotifyDataSetChanged")
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            for (QueryDocumentSnapshot documentSnapshot : task.getResult()){
                                ProductModel list= (new ProductModel(Objects.requireNonNull(documentSnapshot.get("p_img")).toString(),
                                        Objects.requireNonNull(documentSnapshot.get("p_name")).toString(),
                                        Objects.requireNonNull(documentSnapshot.get("p_price")).toString(),
                                        Objects.requireNonNull(documentSnapshot.get("p_rating")).toString()));
                                if (pos==0)
                                {
                                    fruitsModel.add(list);
                                }
                                if (pos==1)
                                {
                                    snacksModel.add(list);
                                }
                                switch (pos)
                                {
                                    case 0:
                                        if (!(fruitsModel.size() ==0))
                                        {
                                            homeAdapter=new HomeAdapter(1,fruitsModel,getContext());
                                            fruitsRecycler.setAdapter(homeAdapter);
                                            homeAdapter.notifyDataSetChanged();
                                        }else
                                        {
                                            NoDataAdapter noDataAdapter = new NoDataAdapter(str,getContext());
                                            fruitsRecycler.setAdapter(noDataAdapter);
                                            noDataAdapter.notifyDataSetChanged();
                                            Toast.makeText(getActivity(), "Sorry there are no data", Toast.LENGTH_SHORT).show();
                                        }

                                    case 1:
                                        if (!(snacksModel.size() ==0))
                                        {
                                            homeAdapter=new HomeAdapter(2,snacksModel,getContext());
                                            snacksRecycler.setAdapter(homeAdapter);
                                            homeAdapter.notifyDataSetChanged();
                                        }else
                                        {
                                            NoDataAdapter noDataAdapter = new NoDataAdapter(str,getContext());
                                            snacksRecycler.setAdapter(noDataAdapter);
                                            noDataAdapter.notifyDataSetChanged();
                                            Toast.makeText(getActivity(), "Sorry there are no data", Toast.LENGTH_SHORT).show();
                                        }
                                }

                            }

                        }else {
                            String error=task.getException().getMessage();
                            Toast.makeText(getActivity(),error, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void init(View view) {
        locationGet = view.findViewById(R.id.locationText);
        locationButton = view.findViewById(R.id.locationBtn);
        mFusedLocation = new FusedLocationProviderClient(getActivity());
        if (checkPermissionLocation(getActivity()))
        {
            viewAddress();
        }
        else
        {
            Toast.makeText(getActivity(), "please make sure that your gps is enable to get your current location", Toast.LENGTH_SHORT).show();
            checkPermissionLocation(getActivity());
            locationButton.setOnClickListener(view1 -> viewAddress());
        }

    }

    private void viewAddress() {
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
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
                Geocoder geocoder = new Geocoder(getActivity(), Locale.getDefault());
                try {
                    List<Address> addressesList = geocoder.getFromLocation(location.getLatitude()
                            , location.getLongitude(), 1);

                    locationGet.setText(addressesList.get(0).getAddressLine(0));

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });    }
}