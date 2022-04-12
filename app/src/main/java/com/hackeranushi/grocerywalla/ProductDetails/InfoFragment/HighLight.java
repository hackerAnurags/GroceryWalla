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
import com.hackeranushi.grocerywalla.ProductDetails.ExpandableAdapter.HighLightAdapter;
import com.hackeranushi.grocerywalla.R;

public class HighLight extends Fragment {
    ExpandableListView expandableListView;
    String mid, w_price, w_title,w_rating, w_img,w_review;
    FirebaseFirestore firebaseFirestore;
    FirebaseAuth mAuth;
    TextView description,key_features,ingredients,unit,nutritionInformation;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_high_light, container, false);

//        expandableListView = view.findViewById(R.id.expandCollapse);
//
//        HighLightAdapter highLightAdapter = new HighLightAdapter(getContext());
//        expandableListView.setAdapter(highLightAdapter);
        firebaseFirestore=FirebaseFirestore.getInstance();
        mAuth=FirebaseAuth.getInstance();
        Constaints.current_user=mAuth.getUid();
        Log.d("currentuser",Constaints.current_user);

        description = view.findViewById(R.id.description);
        key_features = view.findViewById(R.id.key_features);
        ingredients = view.findViewById(R.id.ingredients);
        unit = view.findViewById(R.id.unit);
        nutritionInformation = view.findViewById(R.id.nutritionInformation);

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
                            documentSnapshot.getString("p_country");
                            documentSnapshot.getString("p_customer_care");
                            documentSnapshot.getString("p_cut_price");
                            description.setText(documentSnapshot.getString("p_desc"));
                            documentSnapshot.getString("p_disclaimer");
                            documentSnapshot.getString("p_img");
                            documentSnapshot.getString("p_index");
                            ingredients.setText(documentSnapshot.getString("p_ingredients"));
                            key_features.setText(documentSnapshot.getString("p_key"));
                            documentSnapshot.getString("p_manufacture");
                            documentSnapshot.getString("p_marked_by");
                            documentSnapshot.getString("p_name");
                            nutritionInformation.setText(documentSnapshot.getString("p_nutrition"));
                            documentSnapshot.getString("p_offer");
                            documentSnapshot.getString("p_price");
                            documentSnapshot.getString("p_rating");
                            documentSnapshot.getString("p_seller");
                            documentSnapshot.getString("p_shelf_life");
                            unit.setText(documentSnapshot.getString("p_unit"));
                        }
                    }
                });

    }
}