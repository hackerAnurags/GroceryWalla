package com.hackeranushi.grocerywalla.ProductDetails.ProductRating.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.hackeranushi.grocerywalla.ProductDetails.ProductRating.Adapter.UserRatingAdapter;
import com.hackeranushi.grocerywalla.R;

public class Rating extends Fragment {

    RecyclerView userRatingRecycler;
    String[] str=new String[]{"","","","","","","","","","",""};
    TextView userRatingText;
    RatingBar ratingBar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rating, container, false);

        userRatingRecycler = view.findViewById(R.id.rating_recycle);
        ratingBar = view.findViewById(R.id.rating_bar);
        userRatingText = view.findViewById(R.id.user_rating_text);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                userRatingText.setText(""+v);
            }
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        userRatingRecycler.setLayoutManager(layoutManager);
        userRatingRecycler.setHasFixedSize(true);
        UserRatingAdapter userRatingAdapter = new UserRatingAdapter(str,getContext());
        userRatingRecycler.setAdapter(userRatingAdapter);
        return view;
    }
}