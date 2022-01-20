package com.hackeranushi.grocerywalla.ProductDetails.InfoFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.hackeranushi.grocerywalla.ProductDetails.ExpandableAdapter.InfoAdapter;
import com.hackeranushi.grocerywalla.R;

public class Info extends Fragment {
    ExpandableListView expandableListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_info, container, false);

        expandableListView = view.findViewById(R.id.expandCollapse);

        InfoAdapter infoAdapter = new InfoAdapter(getContext());
        expandableListView.setAdapter(infoAdapter);

        return view;
    }
}