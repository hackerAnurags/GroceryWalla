package com.hackeranushi.grocerywalla.ProductDetails.ProductRating.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.hackeranushi.grocerywalla.ProductDetails.ProductRating.Adapter.ExpandableAdapter;
import com.hackeranushi.grocerywalla.R;

public class Questions extends Fragment {

    ExpandableListView expandableListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_questions, container, false);

        expandableListView = view.findViewById(R.id.expandable_listview);
        ExpandableAdapter expandableAdapter = new ExpandableAdapter(getContext());
        expandableListView.setAdapter(expandableAdapter);

        return view;
    }
}