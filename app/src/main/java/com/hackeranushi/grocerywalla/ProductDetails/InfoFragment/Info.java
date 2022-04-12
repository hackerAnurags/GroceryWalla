package com.hackeranushi.grocerywalla.ProductDetails.InfoFragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.hackeranushi.grocerywalla.Helper.Constaints;
import com.hackeranushi.grocerywalla.ProductDetails.ExpandableAdapter.InfoAdapter;
import com.hackeranushi.grocerywalla.R;

public class Info extends Fragment {
    ExpandableListView expandableListView;
    TextView shelf_life,manufacture_details,markedBy,disclaimer,origin,customer_care_details,seller;
    String mid, w_price, w_title,w_rating, w_img,w_review;
    FirebaseFirestore firebaseFirestore;
    FirebaseAuth mAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_info, container, false);

        firebaseFirestore=FirebaseFirestore.getInstance();
        mAuth=FirebaseAuth.getInstance();
        Constaints.current_user=mAuth.getUid();
        Log.d("currentuser",Constaints.current_user);

        shelf_life = view.findViewById(R.id.shelf_life);
        manufacture_details = view.findViewById(R.id.manufacture_details);
        markedBy = view.findViewById(R.id.markedBy);
        disclaimer = view.findViewById(R.id.disclaimer);
        origin = view.findViewById(R.id.origin);
        customer_care_details = view.findViewById(R.id.customer_care_details);
        seller = view.findViewById(R.id.seller);


//        expandableListView = view.findViewById(R.id.expandCollapse);
//
//        InfoAdapter infoAdapter = new InfoAdapter(getContext());
//        expandableListView.setAdapter(infoAdapter);

        if (Constaints.recycler_position==1) {
            Log.d("recycler_position",""+Constaints.recycler_position);
            getProductDetails("ProductList", "Fruits & Vegetables", Constaints.product_id);
        }
        else if (Constaints.recycler_position==2){
            Log.d("recycler_position",""+Constaints.recycler_position);
            getProductDetails("ProductList", "Snacks", Constaints.product_id);

        }
        else if (Constaints.recycler_position==3){
            Log.d("recycler_position",""+Constaints.recycler_position);
            getProductDetails("ProductList", "BakeryProducts", Constaints.product_id);

        }
        else if (Constaints.recycler_position==4){
            Log.d("recycler_position",""+Constaints.recycler_position);
            getProductDetails("ProductList", "TeaCoffee", Constaints.product_id);

        }
        else if (Constaints.recycler_position==5){
            Log.d("recycler_position",""+Constaints.recycler_position);
            getProductDetails("ProductList", "ColdDrinks", Constaints.product_id);

        }
        else if (Constaints.recycler_position==6){
            Log.d("recycler_position",""+Constaints.recycler_position);
            getProductDetails("ProductList", "Grocery", Constaints.product_id);

        }
        else if (Constaints.recycler_position==7){
            Log.d("recycler_position",""+Constaints.recycler_position);
            getProductDetails("ProductList", "Masala", Constaints.product_id);

        }
        else if (Constaints.recycler_position==8){
            Log.d("recycler_position",""+Constaints.recycler_position);
            getProductDetails("ProductList", "BabyCare", Constaints.product_id);

        }
        else if (Constaints.recycler_position==9){
            Log.d("recycler_position",""+Constaints.recycler_position);
            getProductDetails("ProductList", "PersonalCare", Constaints.product_id);

        }
        else if (Constaints.recycler_position==10){
            Log.d("recycler_position",""+Constaints.recycler_position);
            getProductDetails("ProductList", "Cleaning", Constaints.product_id);

        }
        else if (Constaints.recycler_position==11){
            Log.d("recycler_position",""+Constaints.recycler_position);
            getProductDetails("ProductList", "PetCare", Constaints.product_id);

        }

        return view;
    }

    private void getProductDetails(String p_doc, String p_collection, String id) {

        firebaseFirestore.collection("HomeProducts").document(p_doc).collection(p_collection).document(id).get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {

                            DocumentSnapshot documentSnapshot = task.getResult();
                            mid = documentSnapshot.getString("id");
                            origin.setText(documentSnapshot.getString("p_country"));
                            customer_care_details.setText(documentSnapshot.getString("p_customer_care"));
                            documentSnapshot.getString("p_cut_price");
                            documentSnapshot.getString("p_desc");
                            disclaimer.setText(documentSnapshot.getString("p_disclaimer"));
                            documentSnapshot.getString("p_img");
                            documentSnapshot.getString("p_index");
                            documentSnapshot.getString("p_ingredients");
                            documentSnapshot.getString("p_key");
                            manufacture_details.setText(documentSnapshot.getString("p_manufacture"));
                            markedBy.setText(documentSnapshot.getString("p_marked_by"));
                            documentSnapshot.getString("p_name");
                            documentSnapshot.getString("p_nutrition");
                            documentSnapshot.getString("p_offer");
                            documentSnapshot.getString("p_price");
                            documentSnapshot.getString("p_rating");
                            seller.setText(documentSnapshot.getString("p_seller"));
                            shelf_life.setText(documentSnapshot.getString("p_shelf_life"));
                            documentSnapshot.getString("p_unit");
                        }
                    }
                });
    }
}