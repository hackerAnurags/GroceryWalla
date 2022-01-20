package com.hackeranushi.grocerywalla.FragmentHome;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hackeranushi.grocerywalla.HomeProductAdapter.CartAdapter;
import com.hackeranushi.grocerywalla.HomeProductAdapter.HomeAdapter;
import com.hackeranushi.grocerywalla.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class CartFragment extends Fragment {

    RecyclerView cartRecycler,cartProductHorizontalRecycler;
    LinearLayout cartCoupon;
    TextView tip1,tip2,tip3,tip4,extendItems;
    EditText tipChoice;
    CircleImageView deliveryBoyImage;
    CartAdapter cartAdapter;
    String [] str = {"","","","","","","","","","","","","",""};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_cart, container, false);

        cartRecycler = view.findViewById(R.id.cart_recycle);
        cartProductHorizontalRecycler= view.findViewById(R.id.cart_more_product_recycle);
        cartCoupon = view.findViewById(R.id.cart_coupon);
        tip1 = view.findViewById(R.id.cart_instant_tip1);
        tip2 = view.findViewById(R.id.cart_instant_tip2);
        tip3 = view.findViewById(R.id.cart_instant_tip3);
        tip4 = view.findViewById(R.id.cart_instant_tip4);
        tipChoice = view.findViewById(R.id.cart_instant_tip_choose);
        extendItems = view.findViewById(R.id.cart_more_like_product);
        deliveryBoyImage = view.findViewById(R.id.cart_delivery_boy_profile_image);

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity());
        cartRecycler.setLayoutManager(layoutManager);
        cartRecycler.setHasFixedSize(true);
        cartAdapter = new CartAdapter(0,str,getContext());
        cartRecycler.setAdapter(cartAdapter);

        RecyclerView.LayoutManager layoutManager1=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        cartProductHorizontalRecycler.setLayoutManager(layoutManager1);
        cartProductHorizontalRecycler.setHasFixedSize(true);
//        homeModels1 = new ArrayList<>();
        cartAdapter=new CartAdapter(1,str,getContext());
        cartProductHorizontalRecycler.setAdapter(cartAdapter);
        return view;
    }
}