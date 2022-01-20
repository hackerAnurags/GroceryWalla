package com.hackeranushi.grocerywalla.FragmentHome;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hackeranushi.grocerywalla.HomeProductAdapter.OrderAdapter;
import com.hackeranushi.grocerywalla.R;

public class OrderFragment extends Fragment {

    RecyclerView orderRecycle;
    OrderAdapter orderAdapter;
    String [] str = {"","","","","","","","","","","","","",""};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_order, container, false);

        orderRecycle = view.findViewById(R.id.order_recycle);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        orderRecycle.setLayoutManager(layoutManager);
        orderRecycle.setHasFixedSize(true);
        orderAdapter = new OrderAdapter(str,getContext());
        orderRecycle.setAdapter(orderAdapter);

        return view;
    }
}