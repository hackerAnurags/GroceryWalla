package com.hackeranushi.grocerywalla.FragmentHome;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hackeranushi.grocerywalla.Activities.Category;
import com.hackeranushi.grocerywalla.HomeProductAdapter.HomeAdapter;
import com.hackeranushi.grocerywalla.HomeProductAdapter.HomeViewAdapter;
import com.hackeranushi.grocerywalla.HomeProductModel.HomeModel;
import com.hackeranushi.grocerywalla.R;
import com.skydoves.elasticviews.ElasticButton;
import com.skydoves.elasticviews.ElasticImageView;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

public class HomeFragment extends Fragment {

    RecyclerView firstRecycler,secondRecycler,thirdRecycler,fourthRecycler,fifthRecycler,sixthRecycler
            ,seventhRecycler,eightRecycler,ninthRecycler,tenthRecycler;
    ViewPager homeHeaderViewPager;
    CircleIndicator indicator;
    ElasticButton category;

    private ArrayList<HomeModel> homeModels;
    private ArrayList<HomeModel> homeModels1;
    private ArrayList<HomeModel> homeModels2;
    private ArrayList<HomeModel> homeModels3;
    private ArrayList<HomeModel> homeModels4;
    private ArrayList<HomeModel> homeModels5;
    private ArrayList<HomeModel> homeModels6;
    private ArrayList<HomeModel> homeModels7;
    private ArrayList<HomeModel> homeModels8;
    private ArrayList<HomeModel> homeModels9;
    String[] str=new String[]{"","","","","","","","","","",""};
    HomeAdapter homeAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);

        firstRecycler=view.findViewById(R.id.firstRecycle);
        secondRecycler=view.findViewById(R.id.secondRecycle);
        thirdRecycler=view.findViewById(R.id.thirdRecycle);
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


        HomeViewAdapter homeViewAdapter =new HomeViewAdapter(getActivity());
        homeHeaderViewPager.setAdapter(homeViewAdapter);
        indicator.setViewPager(homeHeaderViewPager);


        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(),3);
        firstRecycler.setLayoutManager(layoutManager);
        firstRecycler.setHasFixedSize(true);
//        homeModels = new ArrayList<>();
        homeAdapter = new HomeAdapter(0,str,getContext());
        firstRecycler.setAdapter(homeAdapter);

        RecyclerView.LayoutManager layoutManager1=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        secondRecycler.setLayoutManager(layoutManager1);
        secondRecycler.setHasFixedSize(true);
//        homeModels1 = new ArrayList<>();
        homeAdapter=new HomeAdapter(1,str,getContext());
        secondRecycler.setAdapter(homeAdapter);

        RecyclerView.LayoutManager layoutManager2=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        thirdRecycler.setLayoutManager(layoutManager2);
        thirdRecycler.setHasFixedSize(true);
//        homeModels2 = new ArrayList<>();
        homeAdapter=new HomeAdapter(2,str,getContext());
        thirdRecycler.setAdapter(homeAdapter);

        RecyclerView.LayoutManager layoutManager3=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        fourthRecycler.setLayoutManager(layoutManager3);
        fourthRecycler.setHasFixedSize(true);
//        homeModels3 = new ArrayList<>();
        homeAdapter=new HomeAdapter(3,str,getContext());
        fourthRecycler.setAdapter(homeAdapter);

        RecyclerView.LayoutManager layoutManager4=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        fifthRecycler.setLayoutManager(layoutManager4);
        fifthRecycler.setHasFixedSize(true);
//        homeModels4 = new ArrayList<>();
        homeAdapter=new HomeAdapter(4,str,getContext());
        fifthRecycler.setAdapter(homeAdapter);

        RecyclerView.LayoutManager layoutManager5=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        sixthRecycler.setLayoutManager(layoutManager5);
        sixthRecycler.setHasFixedSize(true);
//        homeModels5 = new ArrayList<>();
        homeAdapter=new HomeAdapter(5,str,getContext());
        sixthRecycler.setAdapter(homeAdapter);

        RecyclerView.LayoutManager layoutManager6=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        seventhRecycler.setLayoutManager(layoutManager6);
        seventhRecycler.setHasFixedSize(true);
//        homeModels6 = new ArrayList<>();
        homeAdapter=new HomeAdapter(6,str,getContext());
        seventhRecycler.setAdapter(homeAdapter);

        RecyclerView.LayoutManager layoutManager7=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        eightRecycler.setLayoutManager(layoutManager7);
        eightRecycler.setHasFixedSize(true);
//        homeModels7 = new ArrayList<>();
        homeAdapter=new HomeAdapter(7,str,getContext());
        eightRecycler.setAdapter(homeAdapter);

        RecyclerView.LayoutManager layoutManager8=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        ninthRecycler.setLayoutManager(layoutManager8);
        ninthRecycler.setHasFixedSize(true);
//        homeModels8 = new ArrayList<>();
        homeAdapter=new HomeAdapter(8,str,getContext());
        ninthRecycler.setAdapter(homeAdapter);

        RecyclerView.LayoutManager layoutManager9=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        tenthRecycler.setLayoutManager(layoutManager9);
        tenthRecycler.setHasFixedSize(true);
//        homeModels9 = new ArrayList<>();
        homeAdapter=new HomeAdapter(9,str,getContext());
        tenthRecycler.setAdapter(homeAdapter);

        category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Category.class);
                startActivity(intent);
            }
        });

        return view;
    }
}